import * as ActionTypes from "./ActionTypes";


export default function TradeReducer(state = [], action){
    
    switch(action.type) {
        case ActionTypes.CREATE_TRADE: {
            let newState={...state};
            newState.trades.push(action.payload.trade);
            return newState;
        }
           
        case ActionTypes.EDIT_TRADE: {
            return state.map( item => {
                if (item.id != action.payload.id) 
                    return item;
                
                return Object.assign({}, item, {qty: action.payload.qty});
            })
        }

        case ActionTypes.DELETE_TRADE:{
            let newState={...state};
            newState.trades=newState.trades.filter(trade => trade.id != action.payload.id)
            return newState; 
        }

        case ActionTypes.SERACH_TRADES:{
            let newState={...state};
            newState.trades=action.payload.trades;
            return newState; 
        }

        case ActionTypes.TRADE_DATA_INIT_LOADING:
            return Object.assign({}, state, {loading: action.payload.loading})

        case ActionTypes.TRADE_DATA_INIT:
            return Object.assign({}, state, {trades:action.payload.trades});

        default:
            return state;
    }
}

