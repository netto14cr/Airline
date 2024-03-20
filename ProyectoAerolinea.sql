
---------------C R E A M O S __ T A B L A __ D E __ A D M I N I S T R A D O R E S ----------------------------------

drop table administradores cascade constraints;
create table administradores(
    
    Dia varchar(255),
    Hora varchar(255),
    Mes varchar(255),
    Anio varchar(255),
    identificacion varchar(255),
    contrasenia varchar(255),
    nombre varchar(255),
    apellido1 varchar(255),
    apellido2 varchar(255),
    correoElectronico varchar(255),
    direccion varchar(255),
    tipoUsuario varchar(255)
    ,telefono varchar(255)
    ,celular varchar(255)
    ,PRIMARY KEY (identificacion)

);

-------------------- I N S E R T A R __ A D M I N I S T R  A D O R ---------------------
create or replace procedure insertarAdministrador(d in administradores.Dia%type,h in administradores.Hora%type,m in administradores.Mes%type,
a in administradores.Anio%type,i in administradores.identificacion%type,contr in administradores.contrasenia%type,nom in administradores.nombre%type
,ape1 in administradores.apellido1%type,ape2 in administradores.apellido2%type, correo in administradores.correoElectronico%type,dir in administradores.direccion%type
, tip in administradores.tipousuario%type,tel in administradores.telefono%type, cel in administradores.celular%type)
as 
    
begin
    insert into administradores values(d,h,m,a,i,contr,nom,ape1,ape2,correo,dir,tip,tel,cel);
end;
/
show errors;

--insert into administradores values('lunes','10','octubre','2019','123','','Juan','Quiros','Lozano','juan122$@gmail.com','San Francisco','Cliente','24533','61966888');

-----------------------M O D I F I C A R __ A D M I N I S T R A D O R ------------------------------

create or replace procedure modificarAdministrador(d in administradores.Dia%type,h in administradores.Hora%type,m in administradores.Mes%type,
a in administradores.Anio%type,i in administradores.identificacion%type,contr in administradores.contrasenia%type,nom in administradores.nombre%type
,ape1 in administradores.apellido1%type,ape2 in administradores.apellido2%type, correo in administradores.correoElectronico%type,dir in administradores.direccion%type
, tip in administradores.tipousuario%type,tel in administradores.telefono%type, cel in administradores.celular%type)
as

begin
update administradores
set
dia=d,hora=h,mes=m,anio=a,identificacion=i,contrasenia=contr,nombre=nom,apellido1=ape1,apellido2=ape2,correoelectronico=correo
,direccion=dir,tipousuario=tip,telefono=tel,celular=cel
where administradores.identificacion=i;
end;
/
show errors;

-----------------------E L I M I N A R __ A D M I N I S T R A D O R ------------------------------

create or replace procedure eliminarAdministrador(i in administradores.identificacion%type)
as

begin
    delete from administradores where identificacion=i;
end;
/
show errors;
----------------------- L I S T A R __ A D M I N I S T R A D O R E S ------------------------------
 create or replace package types
as
    type ref_cursor is ref cursor;
end;

/

create or replace function listarAdministradores
return types.ref_cursor
as 
    administrador_cursor types.ref_cursor;
begin
    open administrador_cursor for
    select administradores.identificacion,administradores.nombre,administradores.apellido1,administradores.apellido2,administradores.celular,administradores.contrasenia from administradores;
return administrador_cursor;
end;
/
show errors;

----------------------- C O N S U L T A R __ A D M I N I S T R A D O R E S ------------------------------

create or replace function consultarAdministrador(i in administradores.identificacion%type)
return types.ref_cursor
as
 consulta_cursor types.ref_cursor;
begin
    open consulta_cursor for
    select * from administradores where i=administradores.identificacion;
return consulta_cursor;
end;
/
show errors;


---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------- S E C C I O N __ C L I E N T E ------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------

drop table clientes cascade constraints;
create table clientes(
    
    Dia varchar(255),
    Hora varchar(255),
    Mes varchar(255),
    Anio varchar(255),
    identificacion varchar(255),
    contrasenia varchar(255),
    nombre varchar(255),
    apellido1 varchar(255),
    apellido2 varchar(255),
    correoElectronico varchar(255),
    direccion varchar(255),
    tipoUsuario varchar(255)
    ,telefono varchar(255)
    ,celular varchar(255)
    ,PRIMARY KEY (identificacion)

);

-------------------- I N S E R T A R __ C L I E N T E  ---------------------
create or replace procedure insertarCliente(d in clientes.Dia%type,h in clientes.Hora%type,m in clientes.Mes%type,
a in clientes.Anio%type,i in clientes.identificacion%type,contr in clientes.contrasenia%type,nom in clientes.nombre%type
,ape1 in clientes.apellido1%type,ape2 in clientes.apellido2%type, correo in clientes.correoElectronico%type,dir in clientes.direccion%type
, tip in clientes.tipousuario%type,tel in clientes.telefono%type, cel in clientes.celular%type)
as 
    
begin
    insert into clientes values(d,h,m,a,i,contr,nom,ape1,ape2,correo,dir,tip,tel,cel);
end;
/
show errors;

--insert into clientes values('lunes','10','octubre','2019','123','','Juan','Quiros','Lozano','juan122$@gmail.com','San Francisco','Cliente','24533','61966888');

-----------------------M O D I F I C A R __ C L I E N T E ------------------------------

create or replace procedure modificarCliente(d in clientes.Dia%type,h in clientes.Hora%type,m in clientes.Mes%type,
a in clientes.Anio%type,i in clientes.identificacion%type,contr in clientes.contrasenia%type,nom in clientes.nombre%type
,ape1 in clientes.apellido1%type,ape2 in clientes.apellido2%type, correo in clientes.correoElectronico%type,dir in clientes.direccion%type
, tip in clientes.tipousuario%type,tel in clientes.telefono%type, cel in clientes.celular%type)
as

begin
update clientes
set
dia=d,hora=h,mes=m,anio=a,identificacion=i,contrasenia=contr,nombre=nom,apellido1=ape1,apellido2=ape2,correoelectronico=correo
,direccion=dir,tipousuario=tip,telefono=tel,celular=cel
where clientes.identificacion=i;
end;
/
show errors;

-----------------------E L I M I N A R __ C L I E N T E ------------------------------

create or replace procedure eliminarCliente(i in clientes.identificacion%type)
as

begin
    delete from clientes where identificacion=i;
end;
/
show errors;
----------------------- L I S T A R __ C L I E N T E S ------------------------------
 create or replace package types
as
    type ref_cursor is ref cursor;
end;

/

create or replace function listarClientes
return types.ref_cursor
as 
    cliente_cursor types.ref_cursor;
begin
    open cliente_cursor for
    select clientes.identificacion,clientes.nombre,clientes.apellido1,clientes.apellido2,clientes.celular,clientes.contrasenia from clientes;
return cliente_cursor;
end;
/
show errors;
----------------------- C O N S U L T A R __ C L I E N T E S ------------------------------

create or replace function consultarCliente(i in clientes.identificacion%type)
return types.ref_cursor
as
 consulta_cursor types.ref_cursor;
begin
    open consulta_cursor for
    select * from clientes where i=clientes.identificacion;
return consulta_cursor;
end;
/
show errors;
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------- S E C C I O N __ A V I O N E S ------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------

    
drop table aviones cascade constraints;
create table aviones(
     
     identificacion varchar(255)
    ,anio varchar(255)
    ,modelo varchar(255)
    ,marca varchar(255)
    ,cantidadPasajeros int
    ,primary key(identificacion)

);

--insert into aviones values('111','2019','jet','toyota',45);

--------------------- I N S E R T A R __ A V I O N ----------------

create or replace procedure insertarAvion(i in aviones.identificacion%type,a in aviones.anio%type,m in aviones.modelo%type,
marc in aviones.marca%type,cnt in aviones.cantidadpasajeros%type)
as
begin
    insert into aviones values(i,a,m,marc,cnt);
end;
/
show errors;

-------------------- C O N S U L T A R __ A V I O N  ----------------------

create or replace function consultarAvion(i in aviones.identificacion%type)
return types.ref_cursor
as
 consulta_cursor types.ref_cursor;
begin
    open consulta_cursor for
    select * from aviones where i=aviones.identificacion;
return consulta_cursor;
end;
/
show errors;
---------------------E L I M I N A R __ A V I O N ----------------

create or replace procedure eliminarAvion(i in aviones.identificacion%type)
as
begin
    delete from aviones where i=aviones.identificacion;
end;
/
show errors;

--------------------- L I S T A R __ A V I O N E S----------------

 create or replace package types
as
    type ref_cursor is ref cursor;
end;

/

create or replace function listarAviones
return types.ref_cursor
as 
    avion_cursor types.ref_cursor;
begin
    open avion_cursor for
    select * from aviones;
return avion_cursor;
end;
/
show errors;

------------------------------- M O D I F I C A R __ A V I O N E S ------------------------------------


create or replace procedure modificarAvion(iss in aviones.identificacion%type,a in aviones.anio%type , m in aviones.modelo%type
,mar in aviones.marca%type, cant in aviones.cantidadpasajeros%type)
as

begin
update aviones
set
anio=a,modelo=m,marca=mar,cantidadPasajeros=cant

where aviones.identificacion=iss;
end;
/
show errors;
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------- S E C C I O N __ R U T A S ------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------


    
drop table rutas cascade constraints;
create table rutas(
    identificador varchar(255),
    paisOrigen varchar(255),
    paisDestino varchar(255), 
    DiaS varchar(255),
    HoraS varchar(255),
    MesS varchar(255),
    AnioS varchar(255),
    DiaL varchar(255),
    HoraL varchar(255),
    MesL varchar(255),
    AnioL varchar(255),
    primary key(identificador)
);


---insert into rutas values('666','Costa Rica','Jamaica','Lunes','10','octubre','2019');

------------------------------- I N S E R T A R __ R U T A S ------------------------------------

create or replace procedure insertarRuta(i in rutas.identificador%type, po in rutas.paisorigen%type , pd in rutas.paisDestino%type
,d in rutas.dias%type,h in rutas.horas%type , m in rutas.mess%type , a in rutas.anios%type
,dl in rutas.dial%type,hl in rutas.horal%type , ml in rutas.mesl%type , al in rutas.aniol%type)
as
begin
    insert into rutas values(i,po,pd,d,h,m,a,dl,hl,ml,al);
end;
/
show errors;

------------------------------- E L I M I N A R __ R U T A S ------------------------------------

create or replace procedure eliminarRuta(i in rutas.identificador%type)
as 
begin
    delete from rutas where i=rutas.identificador;
end;
/
show errors;
------------------------------- L I S T A R __ R U T A S ------------------------------------

 create or replace package types
as
    type ref_cursor is ref cursor;
end;

/
create or replace function listarRutas
return types.ref_cursor
as 
    rutas_cursor types.ref_cursor;
begin
    open rutas_cursor for
    select * from rutas;
return rutas_cursor;
end;
/
show errors;

---------------------------M O D I F I C A R __ R U T A--------------------------------------

create or replace procedure modificarRuta(i in rutas.identificador%type , po in rutas.paisOrigen%type,
pd in rutas.paisdestino%type,d in rutas.dias%type, h in rutas.horas%type , m in rutas.mess%type,a in rutas.anios%type

,dl in rutas.dial%type,hl in rutas.horal%type , ml in rutas.mesl%type , al in rutas.aniol%type
)
as

begin
update rutas
set
identificador=i,paisOrigen=po,paisDestino=pd,
dias=d,horas=h,mess=m,anios=a,
dial=dl,horal=hl,mesl=m,aniol=a

where identificador=i;

end;
/
show errors;


------------------------------- C O N S U L T A R __ R U T A ---------------------------------------------


create or replace function consultarRuta(i in rutas.identificador%type)
return types.ref_cursor
as
 consulta_cursor types.ref_cursor;
begin
    open consulta_cursor for
    select * from rutas where i=rutas.identificador;
return consulta_cursor;
end;
/
show errors;


---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------- S E C C I O N __ V U E L O S --------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------

drop table vuelos cascade constraints;
create table vuelos(
    identificacion varchar(255),
    precio int ,
    idavion varchar(255) unique,
    idruta varchar(255),
    tipoVuelo varchar(255)
    
    ,primary key(identificacion),
    foreign key (idruta) references rutas(identificador)
    ,foreign key (idavion) references aviones(identificacion)
);


----------------------------------- I N S E R T A R __ V U E L O------------------------------------

create or replace procedure insertarVuelo(i in vuelos.identificacion%type,p in vuelos.precio%type , idA in vuelos.idavion%type,
idR in vuelos.idruta%type,t in vuelos.tipoVuelo%type)

as 
begin
    insert into vuelos values(i,p,idA,idR,t);
end;
/
show errors;

----------------------------------- E L I M I N A R __ V U E L O------------------------------------

create or replace procedure eliminarVuelo(i in vuelos.identificacion%type)

as 
begin
    delete from vuelos where i=vuelos.identificacion;-- eliminamos el vuelo y el avion con esos pasajeros los liberamos...
    update aviones
    set aviones.cantidadpasajeros=60
    where (select vuelos.idAvion from vuelos where i = vuelos.identificacion)=aviones.identificacion;
end;
/
show errors;

----------------------------------- M O D I F I C A R  __ V U E L O------------------------------------

create or replace procedure modificarVuelo(i in vuelos.identificacion%type,p in vuelos.precio%type ,
idR in vuelos.idruta%type,t in vuelos.tipoVuelo%type)
as 
begin
   update vuelos
   set precio=p,idruta=idR,tipoVuelo=t
   where i=vuelos.identificacion;
end;
/
show errors;

----------------------------------- L I S T A R  __ V U E L O------------------------------------
create or replace package types
as
    type ref_cursor is ref cursor;
end;
/

create or replace function listarVuelos
return types.ref_cursor
as 
    vuelos_cursor types.ref_cursor;
begin
open vuelos_cursor for
    select vuelos.identificacion,vuelos.precio, 
    vuelos.tipoVuelo,rutas.paisOrigen,rutas.paisDestino,rutas.dias,rutas.mess,rutas.anios,rutas.horas,
    rutas.dial,rutas.mesl,rutas.aniol,rutas.horal,aviones.cantidadPasajeros from 
    ((vuelos inner join rutas on vuelos.idruta=rutas.identificador)inner join aviones on vuelos.idavion=aviones.identificacion);
    /*
    select vuelos.identificacion,vuelos.precio, 
    vuelos.tipoVuelo,rutas.paisOrigen,rutas.paisDestino,rutas.dia,rutas.mes,rutas.anio,rutas.hora,aviones.marca from 
    ((vuelos inner join rutas on vuelos.idruta=rutas.identificador) inner join aviones on vuelos.idavion=aviones.identificacion);*/
return vuelos_cursor;
end;
/
show errors;


----------------------------------- C O N S U L T A R  __ V U E L O------------------------------------
create or replace function consultarVuelo(i in vuelos.identificacion%type)
return types.ref_cursor
as
 consulta_cursor types.ref_cursor;
begin
    
    open consulta_cursor for
   -- select * from vuelos where i = vuelos.identificacion;
    select vuelos.identificacion,vuelos.precio, 
    vuelos.tipoVuelo,rutas.paisOrigen,rutas.paisDestino,rutas.dias,rutas.mess,rutas.anios,rutas.horas,
    rutas.dial,rutas.mesl,rutas.aniol,rutas.horal,aviones.cantidadPasajeros from 
    ((vuelos inner join rutas on vuelos.idruta=rutas.identificador)inner join aviones on vuelos.idavion=aviones.identificacion)where i=vuelos.identificacion;
return consulta_cursor;
end;
/
show errors;

//--------------------------------------------------------------------------------------------------------
//--------------------------------------------LISTAR AVIONES DISPONIBLES----------------------------------
//--------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------


create or replace package types
as
    type ref_cursor is ref cursor;
end;
/

create or replace function listarAvionesDisponibles
return types.ref_cursor
as 
    vuelos_cursor types.ref_cursor;
begin
open vuelos_cursor for
select aviones.identificacion from aviones left join vuelos on aviones.identificacion=vuelos.idavion where vuelos.idavion is null;
return vuelos_cursor;
end;
/
show errors;


---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------- S E C C I O N __ H I S T O R I C O __ C O M P R A S --------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------

drop table historicoCompras cascade constraints;
create table historicoCompras
(
       
    identificacion varchar(255),
    paisOrigen varchar(255),
    paisDestino varchar(255),
    precio varchar(255),
    Dia varchar(255),
    Hora varchar(255),
    Mes varchar(255),
    Anio varchar(255),
    numVuelo varchar(255)
    ,foreign key (identificacion) references clientes(identificacion)
);

--------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------
----REVISAR---->https://www.w3schools.com/sql/sql_insert_into_select.asp
--------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------- I N S E R T A R __ H I S T O R I C O __ C O M P R A S ----------------------------------------------------------
create or replace procedure insertarHistoricoCompras(i in clientes.identificacion%type,
po in rutas.paisorigen%type , pd in rutas.paisdestino%type , p in vuelos.precio%type , m in rutas.mess%type,d in rutas.dias%type,a in rutas.anios%type
,numVuelo in vuelos.identificacion%type,h in historicocompras.hora%type)
as 
begin
    insert into historicoCompras values(i,po,pd,p,d,h,m,a,numVuelo);
    update aviones
    set cantidadPasajeros=cantidadPasajeros-1
    where (select vuelos.idavion from vuelos where numVuelo=vuelos.identificacion)=aviones.identificacion;
end;
/
show errors;

--------------------------------- L I S T A R __ H I S T O R I C O __ C O M P R A S --------------------------------------------------------------
create or replace package types
as
    type ref_cursor is ref cursor;
end;
/
create or replace function listarHistoricoCompras(i in historicoCompras.identificacion%type)
return types.ref_cursor
as 
    historico_cursor types.ref_cursor;
begin
    open historico_cursor for
    select* from historicoCompras where identificacion=i;
    
return historico_cursor;
end;
/
show errors;

---------------------------- I N S E R C I O N __ D A T O S __ P R U E B A -------------------------------------

---1° . INSERCION DE UN ADMINISTRADOR
insert into administradores values('2','18','3','1987','ADMIN','ADMIN','Gerardo','Monster','Cruz','gerardoCruz@gmail.com',
'Palmares , Buenos Aires , Calle Vargas por el Cementerio', 'Administrador','24532526','61966888');

---2° . INSERCION DE UN Cliente

insert into clientes values('6','10','2','1998','123','123','Gabrielo','Barboza','Carvajal','gabrielbarboza41@gmail.com',
'Palmares , Buenos Aires , Tres Marias ', 'Cliente','24532526','61966888');







---3° . INSERCION DE UN Avion

insert into aviones values('647','2019','Jet','360 AIR',45);
insert into aviones values('648','2019','Jet','BOEING',45);
insert into aviones values('649','2019','Jet','AIR',45);
insert into aviones values('650','2019','Jet','FLY',45);
insert into aviones values('655','2019','COMERCIAL','FLY',45);
insert into aviones values('700','2019','COMERCIAL','SKY',45);
insert into aviones values('701','2019','COMERCIAL','STAR',45);



--4°  . INSERCION DE UNA RUTA
-- insert into rutas values(i,po,pd,d,h,m,a,dl,hl,ml,al);

/*------------        Vuelos     desde   Costa Rica                 ------------------------*/
insert into rutas values ('1','Costa Rica','Estados Unidos','2','2','2','2019','3','3','3','2019');
insert into rutas values ('2','Costa Rica','México','3','3','3','2019','4','4','4','2019');
insert into rutas values ('3','Costa Rica','Panamá','5','5','5','2019','5','5','5','2019');
insert into rutas values ('4','Costa Rica','Estados Unidos','5','5','5','2019','4','4','4','2019');
insert into rutas values ('5','Costa Rica','Brasil','6','6','6','2019','7','7','7','2019');

/*------------        Vuelos    desde      Mexico                   ------------------------*/
insert into rutas values ('6','México','Estados Unidos','1','1','1','2019','2','2','2','2019');
insert into rutas values ('7','México','México','2','2','2','2019','3','3','3','2019');
insert into rutas values ('8','México','Panamá','4','4','5','2019','6','6','6','2019');
insert into rutas values ('9','México','Costa Rica','6','6','6','2019','7','7','7','2019');
insert into rutas values ('10','México','Brasil','7','7','7','2019','8','8','8','2019');



/*------------        Vuelos    desde      Pánama                   ------------------------*/
insert into rutas values ('11','Panamá','Estados Unidos','1','1','1','2019','2','2','2','2019');
insert into rutas values ('12','Panamá','México','2','2','2','2019','3','3','3','2019');
insert into rutas values ('13','Panamá','Panamá','4','4','5','2019','6','6','6','2019');
insert into rutas values ('14','Panamá','Costa Rica','6','6','6','2019','7','7','7','2019');
insert into rutas values ('15','Panamá','Brasil','7','7','7','2019','8','8','8','2019');

/*------------        Vuelos    desde      Brasil                   ------------------------*/
insert into rutas values ('11','Panamá','Estados Unidos','1','1','1','2019','2','2','2','2019');
insert into rutas values ('12','Panamá','México','2','2','2','2019','3','3','3','2019');
insert into rutas values ('13','Panamá','Panamá','4','4','5','2019','6','6','6','2019');
insert into rutas values ('14','Panamá','Costa Rica','6','6','6','2019','7','7','7','2019');
insert into rutas values ('15','Panamá','Brasil','7','7','7','2019','8','8','8','2019');


/*------------        Vuelos    desde      Estados Unidos                   ------------------------*/
insert into rutas values ('16','Estados Unidos','Estados Unidos','1','1','1','2019','2','2','2','2019');
insert into rutas values ('17','Estados Unidos','México','2','2','2','2019','3','3','3','2019');
insert into rutas values ('18','Estados Unidos','Panamá','4','4','5','2019','6','6','6','2019');
insert into rutas values ('19','Estados Unidos','Costa Rica','6','6','6','2019','7','7','7','2019');
insert into rutas values ('20','Estados Unidos','Brasil','7','7','7','2019','8','8','8','2019');



--5°  . INSERCION DE UN VUELO

insert into vuelos values ('1',580000,'647','1','solo ida');
insert into vuelos values ('2',580000,'648','2','solo ida');
insert into vuelos values ('3',580000,'649','2','solo ida');
insert into vuelos values ('4',580000,'650','2','solo vuelta');
insert into vuelos values ('5',580000,'655','1','solo vuelta');
insert into vuelos values ('6',580000,'700','2','solo vuelta');
insert into vuelos values ('7',580000,'701','2','solo vuelta');







  



