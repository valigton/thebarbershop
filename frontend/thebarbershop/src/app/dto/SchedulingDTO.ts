import { EmployeeDTO } from "./EmployeeDTO";
import { ServiceDTO } from "./ServiceDTO";

export class SchedulingDTO {
    public id?: number;
    public clientName?: string;
    public clientEmail?: string;
    public date?: Date;
    public employee?: EmployeeDTO;
    public service?: ServiceDTO;
}