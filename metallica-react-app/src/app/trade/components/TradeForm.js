import React,{Component} from "react";

export default class TradeForm extends Component{
    constructor(props) {
        super(props);
        
        this.state={
            tradeDate:'',
            commodity_code:'',
            side:0,
            quantity:'',
            price:'',
            counterparty_code:'',
            location_code:'',
            status:'OPEN'
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

        const trade={
            tradeDate:this.state.tradeDate,

            commodity:{code:commodity_code,
                    description:this.getDescription(this.props.refData.commodity,commodity_code)},

            side:this.state.side,
            quantity:this.state.quantity,
            price:this.state.price,

            counterparty:{code:counterparty_code,
                    description:this.getDescription(this.props.refData.counterparty,counterparty_code)},

            location:{code:location_code,
                description:this.getDescription(this.props.refData.location,location_code)},
            status:'OPEN'
        }

        console.log('Trade to be created : ' , trade);
        this.props.actions.createTrade(trade);
    }

    getDescription(mapData,code){
        return mapData.filter(data=>data.code==code)[0].desc;
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
        
        return (
            
                <form className="form-group" onSubmit={(e) => this.handleSubmit(e)}>
                    <div className="row">
                        <div className="col-lg-6">
                            <label>Trade ID</label>  
                        </div>
                        <div className="col-lg-6">
                             
                        </div>
                    </div>

                    <div className="row margin-bottom-10" >
                        <div className="col-lg-4">
                            <label>Trade Date</label>
                        </div>
                        <div className="col-lg-8">
                            <input type="date" className="form-control" name="tradeDate"
                             onChange={ (e) => this.handleChange(e)}></input>  
                        </div>     
                    </div>

    
                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Commodity</label>
                        </div>
                        <div className="col-lg-8">  
                            <select id="commodity_code" name="commodity_code"  
                                    onChange={ (e) => this.handleChange(e)}>
                                {  
                                    commodityList.map( commodity => (
                                        <option key={commodity.code} value={commodity.code}>
                                            {commodity.code}
                                        </option>
                                    ))
                                }
                            </select> 
                        </div>
                    </div>

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Side</label>
                        </div> 
                        <div className="col-lg-8"> 
                            <input type="radio" value="BUY" name="side" defaultChecked={true}
                                onChange={ (e) => this.handleChange(e)}/><label>BUY</label>
                            <input type="radio" value="SELL" name="side"
                             onChange={ (e) => this.handleChange(e)}/><label>SELL</label>
                        </div>
                    </div>

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Counter party</label>
                        </div>
                        <div className="col-lg-8">  
                            <select id="counterparty_code" name="counterparty_code"
                                onChange={ (e) => this.handleChange(e)}>
                            {  
                                counterpartyList.map( counterparty => (
                                    <option key={counterparty.code} value={counterparty.code}>
                                            {counterparty.code}
                                    </option>
                                ))
                            }
                            </select>
                        </div> 
                    </div>

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Price</label>
                        </div>
                        <div className="col-lg-8">  
                            <input type="text" name="price" 
                            onChange={ (e) => this.handleChange(e)}></input>
                        </div>
                    </div>

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Quantity</label>  
                        </div>
                        <div className="col-lg-8">
                            <input type="text" name="quantity" 
                            onChange={ (e) => this.handleChange(e)}></input>
                        </div>
                    </div>

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                             <label>Location</label>  
                        </div>
                        <div className="col-lg-8">
                            <select id="location_code" name="location_code" 
                                onChange={ (e) => this.handleChange(e)}>
                            {  
                                locationList.map( location => (
                                    <option key={location.code} value={location.code}>
                                            {location.code}
                                    </option>
                                ))
                            }
                            </select> 
                        </div>
                    </div>

                    <div className="row">
                        <div className="row">
                            <div className="col-lg-6">
                            </div>
                            <div className="col-lg-6">
                                 <div className="col-lg-6">
                                    <button type="reset" className="btn btn-default">Cancel</button>
                                 </div>
                                 <div className="col-lg-6">
                                    <button type="submit" className="btn btn-default">Save</button>
                                </div>
                            </div>
                        </div>                        
                    </div>
                </form>
        )
    }
}