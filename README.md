# Zero -Solutions marketing ;

#### Project to analyze the digital presence
- you can register and login, get user, edit, remove and get by role. 
- you can add user informations and edit, get, and remove. 
-  you can add new product and edit, get, remove and pay product. 
- you can add cart, edit, git, remove and pay with cart.
- you can get account Details from Twitter. 
- you can get followers Details from Twitter.
- you can get Tweet Details from Twitter.
- you can get All Tweet user from Twitter.
- you can get Retweeted user from Twitter.
- in this project you can do it :)

### User flow
![flowtchartpng](https://user-images.githubusercontent.com/71227623/173221121-57e66cc4-4509-4ab2-91fc-b3e5478b767f.png)


### Sequence Diagram
                    
![UML Zero project - UML ZERO](https://user-images.githubusercontent.com/71227623/173221554-bcb037ca-b291-43e0-a06e-d2b957b514c1.jpeg)


#### regester　

```java
   public ResponseEntity<ApiResponce> registerUser(@RequestBody @Valid MyUser myUser, Errors errors){
        if (errors.hasErrors()){
           String message = errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(new ApiResponce(message,400));
        }
        myUserService.registerUser(myUser);
        log.info("Register Users");
        return ResponseEntity.status(201).body(new ApiResponce("Success request :)",201));
    }
```
#### future additions
- Tweet with zero 
- post your AD on Tweeter
- add more Api like Snapchat and meta
- to make A project that combines media and technology


#### Thanks :)
