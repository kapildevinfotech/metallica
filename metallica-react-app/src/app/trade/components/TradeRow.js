import React,{Component} from "react";

export default class TradeRow extends Component{
    render(){

        let {trade} = this.props;

        return(
            <div>
                <tr>
                    <td>{trade.date}</td>
                    <td>{trade.commodity}</td>
                    <td>{trade.side}</td>
                    <td>{trade.qty}</td>
                    <td>{trade.price}</td>
                    <td>{trade.counterparty}</td>
                    <td>{trade.location}</td>
                    <td><button onClick={ () => this.props.actions.deleteTrade(trade.id) }>
                            Delete
                        </button>
                    </td>
                </tr>
            </div>
        )
    }
}