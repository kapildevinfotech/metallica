import * as ActionTypes from "./ActionTypes";


export default function TradeReducer(state = [], action){
    switch(action.type) {
        case ActionTypes.CREATE_TRADE: 
            return [...state, action.payload.item];

        case ActionTypes.EDIT_TRADE: {
            return state.map( item => {
                if (item.id != action.payload.id) 
                    return item;
                
                return Object.assign({}, item, {qty: action.payload.qty});
            })
        }

        case ActionTypes.DELETE_TRADE: 
        return state.filter(item => item.id != action.payload.id)

        default:
            return state;
    }
}