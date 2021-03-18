import { Pipe, PipeTransform } from '@angular/core';
import { Address } from '../models/user.model';

@Pipe({
  name: 'address'
})
export class AddressPipe implements PipeTransform {

  transform(address: Address): string {
    if (address == undefined)
      return '/';
    return address?.street + ' ' + address?.number + '\n' + address?.zip + ' ' + address?.city + '\n' + address?.country;
  }

}
