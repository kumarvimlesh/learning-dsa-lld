**Observer Design Pattern**

If there is something which changes its state and its needs to notify to the many 
services/ class which can be referred as Observer

So, there will be Observable and its Observer

Observable would be having its state or data which is changing time to time

Observable:

    State
    List of observers


Observer:

    There would be different type of observer class 
    implementing to an observer interface


Driver code:

    Observable observable = new Observable();
    observable.registerObserver(new StockPriceDisplay());

    observable.updateStock("ABC", 50);

    observable.registerObserver(new TradingBoat());

    observable.updateStock("DEF", 100);
    observable.updateStock("ABC", 75);

Output:

    [StockPriceDisplay] :: stockName : ABC,  stockPrice : 50
    [StockPriceDisplay] :: stockName : DEF,  stockPrice : 100
    [TradingBoat] :: stockName : DEF,  stockPrice : 100
    [StockPriceDisplay] :: stockName : ABC,  stockPrice : 75
    [TradingBoat] :: stockName : ABC,  stockPrice : 75

