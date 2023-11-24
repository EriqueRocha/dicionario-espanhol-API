CREATE TABLE IF NOT EXISTS public.palavra_entity
(
    id SERIAL PRIMARY KEY,
    definicao character varying(500),
    exemplo character varying(255),
    genero character varying(255),
    nome character varying(255),
    nome_cientifico character varying(255),
    nota_contrastiva character varying(255)
);

CREATE TABLE IF NOT EXISTS public.palavra_entity_equivalentele
(
    palavra_entity_id integer NOT NULL,
    genero character varying(255),
    nome character varying(255)
);

CREATE TABLE IF NOT EXISTS public.palavra_entity_image_paths
(
    palavra_entity_id integer NOT NULL,
    image_paths character varying(255)
);

CREATE TABLE IF NOT EXISTS public.palavra_entity_resgistro_dicionariole
(
    palavra_entity_id integer NOT NULL,
    dicionariole character varying(255),
    presenca character varying(255)
);

CREATE TABLE IF NOT EXISTS public.palavra_entity_resgistro_dicionariolp
(
    palavra_entity_id integer NOT NULL,
    dicionariolp character varying(255),
    presenca character varying(255)
);

CREATE TABLE IF NOT EXISTS public.palavra_entity_variante_espanhol
(
    palavra_entity_id integer NOT NULL,
    dicionariole character varying(255),
    genero character varying(255),
    paises character varying(255)[],
    palavra character varying(255)
);

CREATE TABLE IF NOT EXISTS public.palavra_entity_variantelp
(
    palavra_entity_id integer NOT NULL,
    dicionariolp character varying(255)[],
    genero character varying(255),
    nome character varying(255)
);
