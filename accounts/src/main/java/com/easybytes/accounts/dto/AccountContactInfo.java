package com.easybytes.accounts.dto;
/*Sometimes we just need our java class to be data carriers just to get the values someone has to just read the
* data class should not be able to change it what ever the values that are being passed during the object creation
* are final, and we are not allowed to change it instead od creating a constructor and calling the getter method
* we can define a record get this done */

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

//previously it was a record now we need to change it to class since if any of the properties get changed in the
// run time record does not re-initialize the values, in that case we need to restart the all services which is
// a daunting task
@ConfigurationProperties(prefix = "accounts")
//previous version
//public record AccountContactInfo() {
//
//}
@Getter
@Setter
public class AccountContactInfo{
    private String message;
    private Map<String,String> contactDetails;
    private List<String> onCallSupport;
}