create view hora_view as
select hora,count(hora) as frequency from jugador group by (hora)