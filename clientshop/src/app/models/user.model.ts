export interface User {
    id: number;
    pseudo: string;
    password: string;
    lastname: string;
    firstname: string;
    email: string;
    deliveryAddress: Address;
    billingAddress: Address;
}

export interface Address{
    street: string;
    number: string;
    zip: string;
    city: string;
    country: string;
}
