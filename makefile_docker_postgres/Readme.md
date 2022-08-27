Sql script create table and generate 1 million field.<br>
Max response entity - <b>1000</b>. Change maxResponseList in application.yml for correction.<br>
For run type in terminal - <b>make run</b>

for example
1. <b>^.*[ab0d].*$</b> - http://localhost:8080/shop/product?nameFilter=%5E.*%5Bab0d%5D.*$
2. <b>^E.*$</b> - http://localhost:8080/shop/product?nameFilter=%5EE.*$ this too small filter for test seeds
3. <b>%5E.*%5Beva%5D.*$</b> - http://localhost:8080/shop/product?nameFilter=^.*[eva].*$ too small filter for test seeds