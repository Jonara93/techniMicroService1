package be.technifutur.mcommande.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDeliveryName {
    int orderId;
    String deliveryCompany;
}
