drop table if exists log_action_volunteers;

CREATE TABLE log_action_volunteers(

    id serial,
    id_tarea serial,
	id_estado_tarea serial,
	id_estado_tarea_nuevo serial,
    PRIMARY KEY (id)
);

create function TF() returns Trigger 
as
$$
Begin

insert into log_action_volunteers(id_tarea,id_estado_tarea,id_estado_tarea_nuevo) values (old.id,old.id_estado,new.id_estado);

return new;
End
$$
language plpgsql

