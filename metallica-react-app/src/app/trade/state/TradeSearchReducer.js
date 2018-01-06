import * as ActionTypes from "./ActionTypes";


export default function TradeSearchReducer (state = [], action) {
    switch(action.type) {
        case ActionTypes.SERACH_TRADES: 
            return [...state, action.payload.item];

        default:
            return state;
    }
}