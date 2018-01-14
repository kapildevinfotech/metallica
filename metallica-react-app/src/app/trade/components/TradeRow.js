import React,{Component} from "react";

export default class TradeRow extends Component{
    render(){

        let {trade,deleteTrade} = this.props;

        return(
            <tr>
                    <td>{trade.tradeDate}</td>
                    <td>{trade.commodity.code}</td>
                    <td>{trade.side}</td>
                    <td>{trade.quantity}</td>
                    <td>{trade.price}</td>
                    <td>{trade.counterparty.code}</td>
                    <td>{trade.location.code}</td>
                    <td><i className="fa fa-trash-o" aria-hidden="true" 
                        onClick={()=> deleteTrade(trade.id)}></i></td>
                </tr>
        )
    }
}