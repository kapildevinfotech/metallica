import React,{Component} from "react";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Trade from "./trade/containers/Trade";

export class App extends Component{

    render(){
        return (
            <div>
                <Header title="Metallica App"/>  
                <Trade></Trade>    
                <Footer year={2018}></Footer>
            </div>
        )
    }
}