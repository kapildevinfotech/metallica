import React,{Component} from "react";

export default class TradeSearch extends Component{
    render(){
        return(
                <div>
                <form className="form-group">
                    <div>
                        <label>Trade Date</label>
                        <input type="date" className="form-control" id="tradeToDate"></input>
                        <label> to </label>
                        <input type="date" className="form-control" id="tradeFromDate"></input>
                    </div>
                    <div>
                        <label>Commodity</label>  
                        <select id="commodity" name="commodity">
                            <option value="AL">AL</option>
                            <option value="CU">CU</option>
                        </select> 
                    </div>
                    <div>
                    <div>
                        <label>SIDE</label>
                        <input type="checkbox" id="buy" name="side" value="BUY"/>
                        <label>BUY</label>
                    </div>
                    <div>
                        <input type="checkbox" id="sell" name="side" value="SELL"/>
                        <label>SELL</label>
                    </div>
                    </div>
                    <div>
                        <label>Counter party</label>  
                        <select id="counterparty" name="counterparty">
                            <option value="Lorem">Lorem</option>
                            <option value="Ipsum">Ipsum</option>
                        </select> 
                    </div>
                    <div>
                        <label>Location</label>  
                        <select id="location" name="location">
                            <option value="LN">London</option>
                            <option value="NY">New York</option>
                        </select> 
                    </div>
                    <button type="submit" className="btn btn-default">Clear</button>
                    <button type="submit" className="btn btn-default">Search</button>
                </form>
            </div>
        )
    }
}