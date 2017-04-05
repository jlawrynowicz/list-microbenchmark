# ArrayList LinkedList Add Benchmark

Microbenchmark using [jmh](http://openjdk.java.net/projects/code-tools/jmh/) for appending and iterating over 10<sup>6</sup> elements in ArrayList and LinkedList.

## Running

```
mvn clean install
java -jar target/list-microbenchmark-1.0-SNAPSHOT.jar -wi 5 -i 10 -w 1 -r 1 -t 1 -f 1
```

## Example results

Don't ask for my specs, run it and see for yourself!

```
Benchmark                                  Mode  Cnt    Score    Error  Units
ListBenchmark.addToArrayList              thrpt   10  132,512 ?  5,865  ops/s
ListBenchmark.addToArrayListPreallocated  thrpt   10  178,039 ?  4,704  ops/s
ListBenchmark.addToLinkedList             thrpt   10   94,368 ? 16,357  ops/s
ListBenchmark.iterateArrayList            thrpt   10  424,891 ? 11,271  ops/s
ListBenchmark.iterateLinkedList           thrpt   10  131,726 ?  3,931  ops/s
```