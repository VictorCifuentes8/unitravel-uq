insert into ciudad values (1,"Armenia");
insert into ciudad values (2,"Calarca");
insert into ciudad values (3,"Circasia");

insert into cliente values("9234",20,"juan@gmail.com","Juan","5698",3);
insert into cliente values("8524",18,"luisa@gmail.com","Luisa","8521",2);
insert into cliente values("9687",22,"sofia@gmail.com","Sofia","3698",1);

insert into reserva values(1,'2022-05-30','2022-04-25','2022-05-23',1500000.0,2,1,"9234");
insert into reserva values(2,'2022-07-30','2022-08-02','2022-05-23',1500000.0,4,2,"8524");
insert into reserva values(3,'2022-05-08','2022-04-26','2022-05-22',2500000.0,5,3,"9234");

insert into descuento values (1,"Activo",50.000);
insert into descuento values (2,"Activo",20.000);

insert into categoria values (1,"C1");
insert into categoria values (2,"C2");

insert into administrador values ("123",22,"laura@gmail.com","Laura","4567",1);
insert into administrador values ("456",30,"sara@gmail.com","Sara","1234",2);

insert into administrador_hotel values ("1235",25,"Juan@gmail.com","juan","7896",1);
insert into administrador_hotel values ("5698",40,"Olga@gmail.com","olga","8547",2);

insert into hotel values(1,"Calle 41","Hotel ho",5,"7458963","1235",3);
insert into hotel values(2,"Crrera 13","Hotel to",2,"32414698","1235",1);
insert into hotel values(3,"Carrera 5ta","Hotel 5o",5,"312569874","5698",2);
insert into hotel values(4,"Carrera 52","Hotel oi",2,"32414698","1235",3);

insert into habitacion values(1,50.000,5,1);
insert into habitacion values(2,50.000,6,1);

insert into vuelo values(1,"Avianca",1,1,2);
insert into vuelo values(2,"Viva Colombia",2,1,3);
insert into vuelo values(3,"Airlines",3,3,2);

insert into silla values(1,"1B",50.000,1);
insert into silla values(2,"2B",50.000,2);

insert into reservaHabitacion values(1,50.000,1,1);
insert into reservaHabitacion values(2,50.000,2,2);

insert into reservaSilla values(1,true,50.000,1,1);
insert into reservaSilla values(2,false,50.000,2,2);

insert into comentario values(1,5.0,"Muy buen servicio",'2022-05-29',"9234",1);
insert into comentario values(2,2.5,"No me gusto el tamaño de la habitacion",'2022-05-29',"8524",2);

insert into cliente_telefonos values("9234","3152698741");
insert into cliente_telefonos values("9234","58745652");
insert into cliente_telefonos values("8524","3152698741");

