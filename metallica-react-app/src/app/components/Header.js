import React, {Component} from "react";
import {NavLink} from "react-router-dom";
import Ticker from "../trade/containers/Ticker";

export default class Header extends Component{
    render(){
       return(
             <div>
                <Ticker></Ticker>
            </div> 
        )
    }
}