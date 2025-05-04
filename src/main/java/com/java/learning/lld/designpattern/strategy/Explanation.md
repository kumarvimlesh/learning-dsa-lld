There are 3 types of vehicles which required different kind of driving skills

Bike require normal drive capability
Compact vehicles require good drive capability
Large vehicles also require good drive capability

Here if we define a drive capability at parent class i.e. in Vehicle class 
then all child class would need to override the drive method

this would lead code repetition 


---- Hence we would need some kind of strategy to avoid code repetition

So will create a drive strategy interface which can be implemented by different types of strategy which are there for drive
Like : NormalDriveStrategy, GoodDriveStrategy

These strategies can be passed as can be used as required implementation to be executed