import React, {Component} from "react";
import {NavLink} from "react-router-dom";
import TickerPanel from "./TickerPanel";
import Navbar from "./Navbar";

export default class Header extends Component{
    render(){
       return(
             <div className="row">
                   <div className="row thumbnail">
                        <TickerPanel />
                    </div>
                    <div>
                        <Navbar/>                        
                    </div>
            </div> 
        )
    }
}