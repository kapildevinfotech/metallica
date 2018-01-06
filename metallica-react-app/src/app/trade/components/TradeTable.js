import React,{Component} from "react";
import TradeRow from "./TradeRow";

export default class TradeTable extends Component{
    render(){
        
        let {trades} = this.props;
        if(!trades){
            trades=[];
        }

        return (
            <div className="row">
            <table className="table-hover">
                <thead>
                    <tr>
                        <th>Trade Date</th>
                        <th>Commodity</th>
                        <th>Side</th>
                        <th>Qty(MT)</th>
                        <th>Price (/MT)</th>
                        <th>Counterparty</th>
                        <th>Location</th>
                    </tr>
                </thead>
                <tbody>
                {
                       trades.map( trade => (
                           <TradeRow trade={trade} 
                                     key={trade.id}>
                            </TradeRow>
                       ))
                }
                </tbody>
            </table>
            </div>
        )
    }
}
