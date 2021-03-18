package be.technifutur.mcommande.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaidOrder implements Serializable {
    int orderId;
}
