import React,{Component} from "react";
import TradeTable from "./TradeTable";
import TradeSearch from "./TradeSearch";
import TradeForm from "./TradeForm";

export default class Trade extends Component{
    render(){
        console.log(this.props.trades);
        return (
             <div>
                <TradeSearch></TradeSearch>
                <TradeTable trades={this.props.trade} 
                            deleteTrade={this.props.actions.deleteTrade} >
                </TradeTable>
                <TradeForm>

                </TradeForm>
             </div>
        )
    }
}
