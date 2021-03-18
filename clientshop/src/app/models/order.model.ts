export interface Order {
    id: number;
    productId: number;
    orderDate: string;
    productQuantity: number;
    isPaid: boolean;
    deliveryCompany: string;
    userId: number;
}