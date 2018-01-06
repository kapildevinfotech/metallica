import React from "react";

import {
    BrowserRouter as Router, 
    Switch,
    Route
} from "react-router-dom";

import {App} from "./App";

import Home from "./components/Home";
import NotFound from "./components/NotFound";
import Trade from "./trade/components/Trade";

export default function Routes(props) {
    return (
        <Router>
            <App>
                <Switch>
                    <Route path="/" exact component={Home} />
                    <Route path="*" component={NotFound} />
                </Switch>
            </App>
        </Router>
    )
}