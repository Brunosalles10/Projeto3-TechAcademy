select * from produto 
where QUANTIDADE  = 0 and valor < 100
and UNIDADE = 'un' and DESCRICAO like '%63'
order by QUANTIDADE ;

select * from produto 
where QUANTIDADE >= 5 and QUANTIDADE <= 50;

select * from produto
where DESCRICAO like '%bola%';

select * from produto
where UNIDADE =  'un';

select * from produto
where CODIGO_CLASSIFICACAO = 20 and QUANTIDADE > 20;

select * from produto 
where DESCRICAO like "bala%" and QUANTIDADE > 6 and UNIDADE = 'UN';

select * from produto 
where DESCRICAO like "martelo%"
and CODIGO_CLASSIFICACAO = 001;

select * from produto 
where CODIGO_CLASSIFICACAO = 002 and UNIDADE != 'cx'
and QUANTIDADE >= 10 and QUANTIDADE <= 50;

select * from produto 
where (DESCRICAO like "camiseta%" and CODIGO_CLASSIFICACAO = 004)
or (CODIGO_CLASSIFICACAO = 008 and DESCRICAO like "bola%");

select * from produto
where CODIGO_CLASSIFICACAO = 003
and UNIDADE = 'pct'
;

select * from produto 
where (CODIGO_CLASSIFICACAO = 006 and DESCRICAO like "%vet%")
or (DESCRICAO like "%Veterinaria%");

select * from produto
where QUANTIDADE > 6 and QUANTIDADE <10;

select * from produto 
where (DESCRICAO like "oleo%")
and UNIDADE = 'L'
;

select *, (QUANTIDADE * VALOR) as TOTAL from produto 
where CODIGO_CLASSIFICACAO = 0015
and UNIDADE = 'CX'

;
