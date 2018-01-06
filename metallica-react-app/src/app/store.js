
import {createStore, combineReducers,applyMiddleware} from "redux";
import thunk from "redux-thunk";

import tradeReducer from "./trade/state/TradeReducer";
import tradeSearchReducer from "./trade/state/tradeSearchReducer";
import tickerReducer from "./trade/state/TickerReducer";


let rootReducer = combineReducers({
    trade: tradeReducer,
    tradeSearch: tradeSearchReducer,
    ticker: tickerReducer
})

let store = createStore(rootReducer,
                    applyMiddleware(thunk));

export default store;

console.log("Initial state ", store.getState());

store.subscribe (function callback() {
    console.log("SUBSCRIBE")
});
