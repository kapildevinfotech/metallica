import React,{Component} from "react";

export default class TradeSearch extends Component{
    constructor(props) {
        super(props);
        
        this.state={
            tradeToDate:'',
            tradeFromDate:'',
            commodity_code:'',
            side:'',
            counterparty_code:'',
            location_code:''
        }
    }

    handleChange(e) {
        let {name, value} = e.target;
        this.setState( {
            [name]: value
        });
    }

    handleSubmit(e) {
        e.preventDefault();
        
        //To check before submit Empty for unchange Drop Down
        const commodity_code =this.state.commodity_code =='' ? this.props.refData.commodity[0].code 
                                                              :this.state.commodity_code;

        const  counterparty_code=this.state.counterparty_code==''?  this.props.refData.counterparty[0].code
                                                                    :this.state.counterparty_code;

        const location_code=this.state.location_code==''? this.props.refData.location[0].code
                                                          :this.state.location_code;


        const search="tradeDate>"+this.state.tradeToDate+",tradeDate<"+this.state.tradeFromDate+
        ",commodity:"+commodity_code+",side:"+this.state.side+",counterparty:"+counterparty_code+
        ",location:"+location_code; 
                
        console.log('Trade to Search : ' , search);
        this.props.actions.searchTrade(search);
    }

    render(){
        let {refData,loading} = this.props;
        
        if(loading==undefined || loading==true){
            return (
                <div>
                    {loading}
                </div>
            )
        }
        
        const commodityList=refData.commodity;
        const locationList=refData.location;
        const counterpartyList=refData.counterparty;

        return(
                <form className="form-group" onSubmit={(e) => this.handleSubmit(e)}>
                    <div className="col-md-3">
                        <div className="row">
                            <label>Trade Date</label>
                        </div>
                        <div className="row">
                            <div className="col-md-5">
                                <input type="date" className="form-control" name="tradeToDate"
                                    onChange={ (e) => this.handleChange(e)}></input>
                            </div> 
                             <div className="col-md-2">
                                <label> to </label>
                            </div>
                            <div className="col-md-5">
                                <input type="date" className="form-control" name="tradeFromDate" 
                                    onChange={ (e) => this.handleChange(e)} ></input>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1">
                        <div className="row">
                            <label>Commodity</label>  
                        </div>
                        <div className="row">
                            <select id="commodity_code" name="commodity_code" 
                                onChange={ (e) => this.handleChange(e)}>
                                {  
                                    commodityList.map( commodity => (
                                        <option key={commodity._id} value={commodity.code}>
                                            {commodity.code}
                                        </option>
                                    ))
                                }
                            </select> 
                        </div>
                    </div>
                    
                    <div className="col-md-2">
                        <div className="row">
                            <label>SIDE</label>
                        </div>
                        <div className="row">   
                            <div className="col-md-6"> 
                                <input type="checkbox" id="buy" name="side" value="BUY" 
                                    onChange={ (e) => this.handleChange(e)}/>
                                <label>BUY</label>
                            </div>
                            <div className="col-md-6"> 
                                <input type="checkbox" id="sell" name="side" value="SELL"
                                    onChange={ (e) => this.handleChange(e)}/>
                                <label>SELL</label>
                            </div>
                        </div>
                    </div>

                    <div className="col-md-2">
                        <div className="row">
                            <label>Counter party</label>  
                        </div>
                        <div className="row">
                        <select id="counterparty_code" name="counterparty_code" 
                            onChange={ (e) => this.handleChange(e)}>
                            {  
                                counterpartyList.map( counterparty => (
                                    <option key={counterparty._id} value={counterparty.code}>
                                        {counterparty.code}
                                    </option>
                                ))
                            }
                            </select>
                        </div>
                    </div>

                    <div className="col-md-2">
                        <div className="row">
                             <label>Location</label>
                        </div>
                        <div className="row">       
                        <select id="location_code" name="location_code" 
                            onChange={ (e) => this.handleChange(e)}>
                            {  
                                locationList.map( location => (
                                    <option key={location._id} value={location.code}>
                                        {location.code}
                                    </option>
                                ))
                            }
                            </select> 
                        </div>
                    </div>
                    <div className="col-md-2">
                        <div className="col-md-6">
                            <button type="reset" className="btn btn-default">Clear</button>
                        </div>
                        <div className="col-md-6">
                            <button type="submit" className="btn btn-default"
                                onChange={ (e) => this.handleChange(e)} >Search</button>
                        </div>
                    </div>
                </form>
        )
    }
}