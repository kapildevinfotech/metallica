
import {createStore, combineReducers,applyMiddleware} from "redux";
import thunk from "redux-thunk";

import tradeReducer from "./trade/state/TradeReducer";
import tickerReducer from "./trade/state/TickerReducer";
import refDataReducer from "./trade/state/RefDataReducer";


let rootReducer = combineReducers({
    tradeData: tradeReducer,
    tickerData: tickerReducer,
    refDataObj: refDataReducer,
})

let store = createStore(rootReducer,
                    applyMiddleware(thunk));

export default store;