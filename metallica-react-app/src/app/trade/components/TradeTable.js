import React,{Component} from "react";
import TradeRow from "./TradeRow";

export default class TradeTable extends Component{
    
    render(){
        let {loading,trades} = this.props;
        if(loading==undefined || loading==true){
            return (
                <div>
                    {loading}
                </div>
            )
        }

        return (
            
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
                            <TradeRow key={trade.id} trade={trade} 
                                    deleteTrade={this.props.actions.deleteTrade}/>
                        ))
                    }
                </tbody>
            </table>
            
        )
    }
}
