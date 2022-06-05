insert into ciudad values (1,"Armenia", "https://www.parlamentoandino.org/images/P-Fundacin-de-Armenia.jpg");
insert into ciudad values (2,"Calarca","https://i.ytimg.com/vi/B8bS1g2UtCQ/maxresdefault.jpg");
insert into ciudad values (3,"Circasia","https://i.ytimg.com/vi/X_W64Y049kc/maxresdefault.jpg");

insert into cliente values("9234",20,"juan@gmail.com","Juan","5698",3);
insert into cliente values("8524",18,"luisa@gmail.com","Luisa","8521",2);
insert into cliente values("9687",22,"sofia@gmail.com","Sofia","3698",1);

insert into reserva values(1,2,1,1,'2022-05-30','2022-04-25','2022-05-23',1500000.0,"9234");
insert into reserva values(2,4,2,1,'2022-07-30','2022-08-02','2022-05-23',1500000.0,"8524");
insert into reserva values(3,5,3,1,'2022-05-08','2022-04-26','2022-05-22',2500000.0,"9234");

insert into categoria values (1,"C1");
insert into categoria values (2,"C2");

insert into administrador values ("123",22,"laura@gmail.com","Laura","4567",1);
insert into administrador values ("456",30,"sara@gmail.com","Sara","1234",2);

insert into administrador_hotel values ("1235",25,"admin1@gmail.com","juan","12345",1);
insert into administrador_hotel values ("5698",40,"admin2@gmail.com","olga","1234",2);

insert into hotel values(1,"d1","Calle 41","Hotel ho",5,"7458963","1235",3);
insert into hotel values(2,"d2","Crrera 13","Hotel to",2,"32414698","1235",1);
insert into hotel values(3,"d3","Carrera 5ta","Hotel 5o",5,"312569874","5698",2);
insert into hotel values(4,"d4","Carrera 52","Hotel oi",2,"32414698","1235",3);

insert into habitacion values(1,2,1,50.000,1);
insert into habitacion values(2,3,2,50.000,1);

insert into caracteristica values(1, "Spa", "1");
insert into caracteristica values(2, "Gimnasio", "1");
insert into caracteristica values(3, "TV", "2");
insert into caracteristica values(4, "Baño", "2");

insert into hotel_caracteristica values(1,1);
insert into hotel_caracteristica values(2,1);
insert into hotel_caracteristica values(3,2);
insert into hotel_caracteristica values(4,2);

insert into habitacion_caracteristica values(1,3);
insert into habitacion_caracteristica values(2,4);

insert into cama values(1,"SENCILLA",1);
insert into cama values(2,"DOBLE",1);
insert into cama values(3,"EXTRA",1);

insert into cama_habitacion values(1,1);
insert into cama_habitacion values(2,2);
insert into cama_habitacion values(2,1);

insert into vuelo values(1,"Avianca",1,1,1,2);
insert into vuelo values(2,"Viva Colombia",2,1,1,3);
insert into vuelo values(3,"Airlines",3,1,3,2);

insert into silla values(1,1,2,50.000,1);
insert into silla values(2,1,3,50.000,2);

insert into reserva_habitacion values(1,50.000,1,1);
insert into reserva_habitacion values(2,50.000,2,2);

insert into reserva_silla values(1,50.000,1,1,1);
insert into reserva_silla values(2,50.000,0,2,2);

insert into comentario values(1,5.0,"Muy buen servicio",'2022-05-29',"9234",1);
insert into comentario values(2,2.5,"No me gusto el tamaño de la habitacion",'2022-05-29',"8524",2);

insert into cliente_telefonos values("9234","3152698741");
insert into cliente_telefonos values("9234","58745652");
insert into cliente_telefonos values("8524","3152698741");