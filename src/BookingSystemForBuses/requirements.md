# OMS

Come up with LLD for Order management platform which will be acting as a core platform,
for managing complete order lifecycle - Booking order, Order Cancellation, Order History
Expectation -

1. Proper DB schema design(Models needed but use in-memory database)
2. Complete booking order flow is written considering all edge cases
3. All flows should be idempotent and states of order should be consistent
4. Platform should be able to onboard new categories like - e-commerce, Train...

### Bonus

1. Implement features: Order Cancellation Order History

### Assumption -

1. Assume peripheral services are already available

- Domain specific booking service - Bus, Flight, Hotel,..
- Third party service providers - Agoda, Cleartrip....

2. Payment Service(having integration with PGs) - Payment creation API, and Payment
   confirmation Push notification(webhook will be sent on successful payment)

**Note** - 60 minutes will be given for implementation