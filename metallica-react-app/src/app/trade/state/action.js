import * as ActionTypes from "./ActionTypes";

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
