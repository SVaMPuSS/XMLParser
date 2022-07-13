
-- Database: DataBase

-- DROP DATABASE IF EXISTS "DataBase";

CREATE DATABASE "DataBase"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.D_CAT_CATALOG

-- DROP TABLE IF EXISTS public."D_CAT_CATALOG";

CREATE TABLE IF NOT EXISTS public."D_CAT_CATALOG"
(
    "ID" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "COMPANY" character varying(100) COLLATE pg_catalog."default",
    "UUID" character varying(100) COLLATE pg_catalog."default",
    "DELIVERY_DATE" date,
    CONSTRAINT "D_CAT_CATALOG_pkey" PRIMARY KEY ("ID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."D_CAT_CATALOG"
    OWNER to postgres;

-- Table: public.F_CAT_PLANTS

-- DROP TABLE IF EXISTS public."F_CAT_PLANTS";

CREATE TABLE IF NOT EXISTS public."F_CAT_PLANTS"
(
    "ID" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "COMMON" character varying(100) COLLATE pg_catalog."default",
    "BOTANICAL" character varying(100) COLLATE pg_catalog."default",
    "ZONE" integer,
    "LIGHT" character varying(100) COLLATE pg_catalog."default",
    "PRICE" numeric,
    "AVAILABILITY" integer,
    "CATALOG_ID" integer,
    CONSTRAINT "F_CAT_PLANTS _pkey" PRIMARY KEY ("ID"),
    CONSTRAINT "F_CAT_PLANTS _CATALOG_ID_fkey" FOREIGN KEY ("CATALOG_ID")
        REFERENCES public."D_CAT_CATALOG" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."F_CAT_PLANTS"
    OWNER to postgres;