### 1. Implement some implementation of Chain

### 2. Register class in [org.example.chain.Chain](src%2Fmain%2Fresources%2FMETA-INF%2Fservices%2Forg.example.chain.Chain)

### 3. You can use it in
```text
ServiceLoader<Chain> chains = ServiceLoader.load(Chain.class);
        for (Chain c : chains) {
            c.printName();
        }
```