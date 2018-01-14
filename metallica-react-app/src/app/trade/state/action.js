import * as ActionTypes from "./ActionTypes";
import config from "config";
import { log } from "util";

export const createTradeAction=(trade) => {
    return {
        type: ActionTypes.CREATE_TRADE,
        payload: {
            trade: trade
        }
    }
}

export const searchTradeAction=(trades) => {
    return {
        type: ActionTypes.SERACH_TRADES,
        payload: {
            trades: trades
        }
    }
}

export const deleteTradeAction = (id) => {
    return {
     type: ActionTypes.DELETE_TRADE,
     payload: {
         id: id
     }
 }
}

export const editTrade = (trade) => {
    return {
        type: ActionTypes.EDIT_TRADE,
        payload: {
            id: trade.id,
            date:trade.date,
            commodity:trade.commodity,
            side:trade.side,
            qty:trade.qty,
            price:trade.price,
            counterparty:trade.counterparty,
            location:trade.location
        }
    }
}

export const refDataLoading = (loading) => {
    return {
     type: ActionTypes.REF_DATA_INIT_LOADING,
     payload: {
        loading: loading
     }
 }
}


export const initRefData = (data) => {
    return {
        type: ActionTypes.REF_DATA_INIT,
        payload: {
            refData : {
                commodity: data.commodity,
                location:data.location,
                counterparty:data.counterparty
            }
        }
    }
}

export function fetchRefData (){
    
    return function(dispatch){
        dispatch(refDataLoading(true));
        let allPromise = Promise.all([
                                fetchJson("http://localhost:9023/reference-data-service/commodity"),
                                fetchJson("http://localhost:9023/reference-data-service/location"),
                                fetchJson("http://localhost:9023/reference-data-service/counterparty")
                                ]);

        allPromise.then(data=> { data.commodity=data[0];
                                 data.location=data[1];
                                 data.counterparty=data[2];  
                                 return data;                  
                                }
                        )
        .then(data => {
            let action=initRefData(data);
            dispatch(action);
            dispatch(refDataLoading(false));
        })
        
    }
}

export const tradeDataLoading = (loading) => {
    return {
     type: ActionTypes.TRADE_DATA_INIT_LOADING,
     payload: {
        loading: loading
     }
 }
}

export const initTradeData = (data) => {
    return {
        type: ActionTypes.TRADE_DATA_INIT,
        payload: {
            trades :data
        }
    }
}


export function fetchTradeData (){
    
    return function(dispatch){
        dispatch(tradeDataLoading(true));
        fetchJson("http://localhost:9023/trade-service/")
        .then(data => {
            let action=initTradeData(data);
            dispatch(action);
            dispatch(tradeDataLoading(false));
        })
    }
}

function fetchJson(url){
    return fetch(url)
    .then(Response => {
        return Response.json();
    });
}

///////////// TRADE CRUD ///////////////////

export function createTrade (trade){
    
    return function(dispatch){
        dispatch(tradeDataLoading(true));
        fetch('http://localhost:9023/trade-service/trade', {
            method: 'post',
            body: JSON.stringify(trade),
            headers : { 'Content-type' : 'application/json', Accept : 'application/json'} 
        }).
        then(response => response.json())
        .then(jsonData => {
            console.log(jsonData);    
            let action=createTradeAction(jsonData);
            dispatch(action);
            dispatch(tradeDataLoading(false));
        })
        .catch(function (error) {
            console.log(error);
        })
    }
}

export function deleteTrade(tradeId){
    return function(dispatch){
    fetch('http://localhost:9023/trade-service/trade/'+tradeId, {
            method: 'delete',
    })
    .then(response => response.json())
    .then(jsonData => {
        console.log(jsonData);    
        dispatch(deleteTradeAction(tradeId));
    })
    }
}

export function searchTrade(search){
    return function(dispatch){
        dispatch(tradeDataLoading(true));
        fetch('http://localhost:9023/trade-service/search?search='+search)
        .then(response => response.json())
        .then(trades => {
            console.log(trades);    
            let action=searchTradeAction(trades);
            dispatch(action);
            dispatch(tradeDataLoading(false));
        })
        .catch(function (error) {
            console.log(error);
        })
    }
}