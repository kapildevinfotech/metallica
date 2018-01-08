import * as ActionTypes from "./ActionTypes";
import config from "config";

export const createTrade=(trade) => {
    return {
        type: ActionTypes.CREATE_TRADE,
        payload: {
            trade: {
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
}

export const deleteTrade = (id) => {
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

export const initLoading = (loading) => {
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
        dispatch(initLoading(true));
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
            console.log(data);
            let action=initRefData(data);
            dispatch(action);
            dispatch(initLoading(false));
        })
        
    }
}

function fetchJson(url){
    return fetch(url)
    .then(Response => {
        return Response.json();
    });
}


