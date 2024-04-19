PGDMP         '                |         
   Cocteleria    14.7    14.7     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                        1262    16817 
   Cocteleria    DATABASE     k   CREATE DATABASE "Cocteleria" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE "Cocteleria";
                postgres    false            �            1259    16818    Mesa    TABLE     d   CREATE TABLE public."Mesa" (
    "Numero_mesa" integer NOT NULL,
    "Cantidad_clientes" integer
);
    DROP TABLE public."Mesa";
       public         heap    postgres    false            �            1259    16823    Pedido    TABLE     �   CREATE TABLE public."Pedido" (
    "id_Pedido" integer NOT NULL,
    "Numero_mesa" integer,
    coctel character varying(25),
    cantidad integer,
    precio_unitario integer,
    precio_total integer
);
    DROP TABLE public."Pedido";
       public         heap    postgres    false            �            1259    16828    Solicitud_Barra    TABLE     �   CREATE TABLE public."Solicitud_Barra" (
    id_solicitud integer NOT NULL,
    "id_Pedido" integer NOT NULL,
    coctel character varying(25),
    cantidad integer,
    precio_unitario integer,
    precio_total integer
);
 %   DROP TABLE public."Solicitud_Barra";
       public         heap    postgres    false            �          0    16818    Mesa 
   TABLE DATA           D   COPY public."Mesa" ("Numero_mesa", "Cantidad_clientes") FROM stdin;
    public          postgres    false    209   �       �          0    16823    Pedido 
   TABLE DATA           o   COPY public."Pedido" ("id_Pedido", "Numero_mesa", coctel, cantidad, precio_unitario, precio_total) FROM stdin;
    public          postgres    false    210          �          0    16828    Solicitud_Barra 
   TABLE DATA           w   COPY public."Solicitud_Barra" (id_solicitud, "id_Pedido", coctel, cantidad, precio_unitario, precio_total) FROM stdin;
    public          postgres    false    211   z       d           2606    16822    Mesa Numero_mesa 
   CONSTRAINT     ]   ALTER TABLE ONLY public."Mesa"
    ADD CONSTRAINT "Numero_mesa" PRIMARY KEY ("Numero_mesa");
 >   ALTER TABLE ONLY public."Mesa" DROP CONSTRAINT "Numero_mesa";
       public            postgres    false    209            f           2606    16827    Pedido Pedido_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public."Pedido"
    ADD CONSTRAINT "Pedido_pkey" PRIMARY KEY ("id_Pedido");
 @   ALTER TABLE ONLY public."Pedido" DROP CONSTRAINT "Pedido_pkey";
       public            postgres    false    210            i           2606    16832 $   Solicitud_Barra Solicitud_Barra_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public."Solicitud_Barra"
    ADD CONSTRAINT "Solicitud_Barra_pkey" PRIMARY KEY (id_solicitud);
 R   ALTER TABLE ONLY public."Solicitud_Barra" DROP CONSTRAINT "Solicitud_Barra_pkey";
       public            postgres    false    211            g           1259    16838    fki_Numero_mesa    INDEX     O   CREATE INDEX "fki_Numero_mesa" ON public."Pedido" USING btree ("Numero_mesa");
 %   DROP INDEX public."fki_Numero_mesa";
       public            postgres    false    210            j           1259    16844    fki_id_Pedido    INDEX     T   CREATE INDEX "fki_id_Pedido" ON public."Solicitud_Barra" USING btree ("id_Pedido");
 #   DROP INDEX public."fki_id_Pedido";
       public            postgres    false    211            k           2606    16833    Pedido Numero_mesa    FK CONSTRAINT     �   ALTER TABLE ONLY public."Pedido"
    ADD CONSTRAINT "Numero_mesa" FOREIGN KEY ("Numero_mesa") REFERENCES public."Mesa"("Numero_mesa") NOT VALID;
 @   ALTER TABLE ONLY public."Pedido" DROP CONSTRAINT "Numero_mesa";
       public          postgres    false    209    210    3172            l           2606    16839    Solicitud_Barra id_Pedido    FK CONSTRAINT     �   ALTER TABLE ONLY public."Solicitud_Barra"
    ADD CONSTRAINT "id_Pedido" FOREIGN KEY ("id_Pedido") REFERENCES public."Pedido"("id_Pedido") NOT VALID;
 G   ALTER TABLE ONLY public."Solicitud_Barra" DROP CONSTRAINT "id_Pedido";
       public          postgres    false    211    3174    210            �      x�3�4�2�4�2�4����� �      �   O   x�3�4�����,��4�442�421�2�2oLTp��ILI�145 a.cNcN�Ģ�Ģ̒D ��؀��Ҁ+F��� ���      �      x������ � �     