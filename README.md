# java-page-replacement-strategies

## Index ##

* [About](#about)
* [Run](#run)
* [Issues](#issues)
* [Contributing](#contributing)
* [Future Plans](#future-plans)

## About ## 

Java simulators for testing various [page replacement schemes](https://en.wikipedia.org/wiki/Cache_replacement_policies). 
Which one is the best? 

* Visit [my website](https://jrquick.com) for me cool stuff!

### Process ###

The program uses three different types of reference strings to test the strategies against varying input. 
The first type is the random which randomly chooses the next page in memory, then there is the loop which takes in 
pages in a cyclical pattern with a few random pages thrown in to closer mimic reality. 
To calculate efficiency I measured the program measures both the time it takes to simulate and the number of page 
faults occurred.

## Run

### Clone

* Clone the repository

    ```git clone git@github.com:jrquick17/java-page-replacement-strategies.git```
    
### Compile
    
* Compile project

    ```javac src/*.java -d target/```
    
### Run
    
* Run Simulator

    ```java -cp target/ Simulator```
    
* Run First In First Out ([FIFO](https://en.wikipedia.org/wiki/FIFO_(computing_and_electronics)))

    ```java -cp target/ FIFO```
    
* Run Least Recently Used ([LRU](https://en.wikipedia.org/wiki/Cache_replacement_policies#Least_recently_used_(LRU))))

    ```java -cp target/ LRU```
    
* Run LRUa

    ```java -cp target/ LRUa```
    
* Run Most Used

    ```java -cp target/ MostUsed```
    
* Run Optimal

    ```java -cp target/ Optimal```
    
* Run [Random](https://en.wikipedia.org/wiki/Cache_replacement_policies#Random_replacement_(RR))

    ```java -cp target/ Random```
    

## Contributing ##

To contribute, submit any pull request and I will have look.  

## Issues ##

If you find any issues feel free to open a request in [the Issues tab](https://github.com/jrquick17/java-page-replacement-strategies/issues). If I have the time I will try to solve any issues but cannot make any guarantees. Feel free to contribute yourself.

### Thanks ###

* [jrquick17](https://github.com/jrquick17)

## Future Plans

* Run using Java 8
* Add Adaptive Replacement Cache ([ARC](https://en.wikipedia.org/wiki/Cache_replacement_policies#Adaptive_replacement_cache_(ARC)))
* Add [Belady's Algorith]((https://en.wikipedia.org/wiki/Cache_replacement_policies#B%C3%A9l%C3%A1dy's_algorithm))
* Add Clock with Adaptive Replacement ([CAR](https://en.wikipedia.org/wiki/Cache_replacement_policies#Clock_with_adaptive_replacement_(CAR)))
* Add Last In First Out ([LIFO](https://en.wikipedia.org/wiki/Cache_replacement_policies#Last_in_first_out_(LIFO)))
* Add Least Frequently Used ([LFU](https://en.wikipedia.org/wiki/Cache_replacement_policies#Least-frequently_used_(LFU)))
* Add LFU with Dynamic Aging ([LFUDA](https://en.wikipedia.org/wiki/Cache_replacement_policies#LFU_with_dynamic_aging_(LFUDA)))
* Add Low Inter-Reference Recency Set ([LIRS](https://en.wikipedia.org/wiki/Cache_replacement_policies#Low_inter-reference_recency_set_(LIRS)))
* Add Most Recently Used ([MRU](https://en.wikipedia.org/wiki/Cache_replacement_policies#Most_recently_used_(MRU)))
* Add Multi Queue ([MQ](https://en.wikipedia.org/wiki/Cache_replacement_policies#Multi_queue_(MQ)))
* Add [Panier]((https://en.wikipedia.org/wiki/Cache_replacement_policies#Pannier:_Container-based_caching_algorithm_for_compound_objects))
* Add [Psuedo-LRU](https://en.wikipedia.org/wiki/Cache_replacement_policies#Pseudo-LRU_(PLRU)))
* Add Segmented Least Recently Used ([SLRU](https://en.wikipedia.org/wiki/Cache_replacement_policies#Segmented_LRU_(SLRU)))
* Add Time Aware Least Recently Used ([TLRU](https://en.wikipedia.org/wiki/Cache_replacement_policies#Time_aware_least_recently_used_(TLRU)))

