import React,{Component} from "react";

export default class TradeForm extends Component{
    render(){
        return (
            <div>
                <form className="form-group">
                    <div>
                    <label>Trade ID</label>  
                     <label>Trade Date</label>
                        <input type="date" className="form-control" id="tradeDate"></input>       
                    </div>
                    <div>
                    <label>Commodity</label>  
                        <select id="commodity" name="commodity">
                            <option value="AL"/>
                            <option value="CU"/>
                            <option value="ZN"/>
                        </select> 
                    </div>
                    <div>
                        <label>Side</label>  
                        <input type="radio" value="BUY" name="side" /><label>BUY</label>
                        <input type="radio" value="SELL" name="side"/> <label>SELL</label>
                    </div>
                    <div>
                        <label>Counter party</label>  
                        <select id="counterparty" name="counterparty">
                            <option value="Lorem"/>
                            <option value="Ipsum"/>
                        </select> 
                    </div>
                    <div>
                        <label>Price</label>  
                        <input type="textbox" id="price"></input>
                    </div>
                    <div>
                        <label>Quantity</label>  
                        <input type="textbox" id="qty"></input>
                    </div>
                    <div>
                        <label>Location</label>  
                        
                        <select id="location" name="location">
                            <option value="LN">London</option>
                            <option value="NY">New York</option>
                        </select> 
                        
                    </div>
                    <button type="submit" className="btn btn-default">Cancel</button>
                    <button type="submit" className="btn btn-default">Save</button>
                </form>
            </div>
        )
    }
}