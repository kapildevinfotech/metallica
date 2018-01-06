import * as ActionTypes from "./ActionTypes";


export default function TickerReducer(state = [], action){
    switch(action.type) {
        case ActionTypes.UPDATE_TICKER: 
            return [...state, action.payload.item];

        default:
            return state;
    }
}