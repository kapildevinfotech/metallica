import React,{Component} from "react";
import TradeRow from "./TradeRow";

export default class TradeTable extends Component{
    render(){
        
        let {trades} = this.props;
        if(!trades){
            trades=[];
        }

        return (
            <div className="row thumbnail">
            <table className="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Trade Date</th>
                        <th scope="col">Commodity</th>
                        <th scope="col">Side</th>
                        <th scope="col">Qty(MT)</th>
                        <th scope="col">Price (/MT)</th>
                        <th scope="col">Counterparty</th>
                        <th scope="col">Location</th>
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
