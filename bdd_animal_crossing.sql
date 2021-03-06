PGDMP     3                     y           animal-crossing    13.2    13.2 k    D           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            E           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            F           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            G           1262    42098    animal-crossing    DATABASE     \   CREATE DATABASE "animal-crossing" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';
 !   DROP DATABASE "animal-crossing";
                postgres    false            ?            1259    42305    archipel    TABLE     ?   CREATE TABLE public.archipel (
    id integer NOT NULL,
    nom character varying(30) NOT NULL,
    localisation character varying(150) NOT NULL,
    id_joueur integer
);
    DROP TABLE public.archipel;
       public         heap    postgres    false            ?            1259    42303    archipel_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.archipel_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.archipel_id_seq;
       public          postgres    false    203            H           0    0    archipel_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.archipel_id_seq OWNED BY public.archipel.id;
          public          postgres    false    202            ?            1259    42412    batiment    TABLE     ?   CREATE TABLE public.batiment (
    id integer NOT NULL,
    nom character varying(100) NOT NULL,
    id_ile integer,
    id_type_batiment integer
);
    DROP TABLE public.batiment;
       public         heap    postgres    false            ?            1259    42410    batiment_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.batiment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.batiment_id_seq;
       public          postgres    false    221            I           0    0    batiment_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.batiment_id_seq OWNED BY public.batiment.id;
          public          postgres    false    220            ?            1259    42326    cinema    TABLE     ?   CREATE TABLE public.cinema (
    id integer NOT NULL,
    nom character varying(30) NOT NULL,
    nombre_places integer NOT NULL,
    id_ile integer
);
    DROP TABLE public.cinema;
       public         heap    postgres    false            ?            1259    42347    cinema_film    TABLE     i   CREATE TABLE public.cinema_film (
    id integer NOT NULL,
    id_cinema integer,
    id_film integer
);
    DROP TABLE public.cinema_film;
       public         heap    postgres    false            ?            1259    42345    cinema_film_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.cinema_film_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.cinema_film_id_seq;
       public          postgres    false    211            J           0    0    cinema_film_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.cinema_film_id_seq OWNED BY public.cinema_film.id;
          public          postgres    false    210            ?            1259    42324    cinema_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.cinema_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.cinema_id_seq;
       public          postgres    false    207            K           0    0    cinema_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.cinema_id_seq OWNED BY public.cinema.id;
          public          postgres    false    206            ?            1259    42438    espace_naturel    TABLE     ?   CREATE TABLE public.espace_naturel (
    id integer NOT NULL,
    nom character varying(30) NOT NULL,
    id_ile integer,
    id_type_espace_naturel integer
);
 "   DROP TABLE public.espace_naturel;
       public         heap    postgres    false            ?            1259    42436    espace_naturel_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.espace_naturel_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.espace_naturel_id_seq;
       public          postgres    false    225            L           0    0    espace_naturel_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.espace_naturel_id_seq OWNED BY public.espace_naturel.id;
          public          postgres    false    224            ?            1259    42339    film    TABLE     a   CREATE TABLE public.film (
    id integer NOT NULL,
    titre character varying(150) NOT NULL
);
    DROP TABLE public.film;
       public         heap    postgres    false            ?            1259    42337    film_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.film_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.film_id_seq;
       public          postgres    false    209            M           0    0    film_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.film_id_seq OWNED BY public.film.id;
          public          postgres    false    208            ?            1259    42365    foret    TABLE     ?   CREATE TABLE public.foret (
    id integer NOT NULL,
    nom character varying(30) NOT NULL,
    superficie integer NOT NULL,
    id_ile integer
);
    DROP TABLE public.foret;
       public         heap    postgres    false            ?            1259    42363    foret_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.foret_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.foret_id_seq;
       public          postgres    false    213            N           0    0    foret_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.foret_id_seq OWNED BY public.foret.id;
          public          postgres    false    212            ?            1259    42386    foret_type_arbre    TABLE     s   CREATE TABLE public.foret_type_arbre (
    id integer NOT NULL,
    id_foret integer,
    id_type_arbre integer
);
 $   DROP TABLE public.foret_type_arbre;
       public         heap    postgres    false            ?            1259    42384    foret_type_arbre_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.foret_type_arbre_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.foret_type_arbre_id_seq;
       public          postgres    false    217            O           0    0    foret_type_arbre_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.foret_type_arbre_id_seq OWNED BY public.foret_type_arbre.id;
          public          postgres    false    216            ?            1259    42313    ile    TABLE     ?   CREATE TABLE public.ile (
    id integer NOT NULL,
    nom character varying(30) NOT NULL,
    localisation character varying(150) NOT NULL,
    id_archipel integer
);
    DROP TABLE public.ile;
       public         heap    postgres    false            ?            1259    42311 
   ile_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.ile_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.ile_id_seq;
       public          postgres    false    205            P           0    0 
   ile_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE public.ile_id_seq OWNED BY public.ile.id;
          public          postgres    false    204            ?            1259    42297    joueur    TABLE     ?   CREATE TABLE public.joueur (
    id integer NOT NULL,
    nom character varying(30) NOT NULL,
    prenom character varying(30) NOT NULL,
    mail character varying(100) NOT NULL
);
    DROP TABLE public.joueur;
       public         heap    postgres    false            ?            1259    42295    joueur_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.joueur_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.joueur_id_seq;
       public          postgres    false    201            Q           0    0    joueur_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.joueur_id_seq OWNED BY public.joueur.id;
          public          postgres    false    200            ?            1259    42378 
   type_arbre    TABLE     h   CREATE TABLE public.type_arbre (
    id integer NOT NULL,
    libelle character varying(30) NOT NULL
);
    DROP TABLE public.type_arbre;
       public         heap    postgres    false            ?            1259    42376    type_arbre_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.type_arbre_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.type_arbre_id_seq;
       public          postgres    false    215            R           0    0    type_arbre_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.type_arbre_id_seq OWNED BY public.type_arbre.id;
          public          postgres    false    214            ?            1259    42404    type_batiment    TABLE     k   CREATE TABLE public.type_batiment (
    id integer NOT NULL,
    libelle character varying(30) NOT NULL
);
 !   DROP TABLE public.type_batiment;
       public         heap    postgres    false            ?            1259    42402    type_batiment_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.type_batiment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.type_batiment_id_seq;
       public          postgres    false    219            S           0    0    type_batiment_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.type_batiment_id_seq OWNED BY public.type_batiment.id;
          public          postgres    false    218            ?            1259    42430    type_espace_naturel    TABLE     q   CREATE TABLE public.type_espace_naturel (
    id integer NOT NULL,
    libelle character varying(30) NOT NULL
);
 '   DROP TABLE public.type_espace_naturel;
       public         heap    postgres    false            ?            1259    42428    type_espace_naturel_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.type_espace_naturel_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.type_espace_naturel_id_seq;
       public          postgres    false    223            T           0    0    type_espace_naturel_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.type_espace_naturel_id_seq OWNED BY public.type_espace_naturel.id;
          public          postgres    false    222            t           2604    42308    archipel id    DEFAULT     j   ALTER TABLE ONLY public.archipel ALTER COLUMN id SET DEFAULT nextval('public.archipel_id_seq'::regclass);
 :   ALTER TABLE public.archipel ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            }           2604    42415    batiment id    DEFAULT     j   ALTER TABLE ONLY public.batiment ALTER COLUMN id SET DEFAULT nextval('public.batiment_id_seq'::regclass);
 :   ALTER TABLE public.batiment ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220    221            v           2604    42329 	   cinema id    DEFAULT     f   ALTER TABLE ONLY public.cinema ALTER COLUMN id SET DEFAULT nextval('public.cinema_id_seq'::regclass);
 8   ALTER TABLE public.cinema ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            x           2604    42350    cinema_film id    DEFAULT     p   ALTER TABLE ONLY public.cinema_film ALTER COLUMN id SET DEFAULT nextval('public.cinema_film_id_seq'::regclass);
 =   ALTER TABLE public.cinema_film ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211                       2604    42441    espace_naturel id    DEFAULT     v   ALTER TABLE ONLY public.espace_naturel ALTER COLUMN id SET DEFAULT nextval('public.espace_naturel_id_seq'::regclass);
 @   ALTER TABLE public.espace_naturel ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    224    225            w           2604    42342    film id    DEFAULT     b   ALTER TABLE ONLY public.film ALTER COLUMN id SET DEFAULT nextval('public.film_id_seq'::regclass);
 6   ALTER TABLE public.film ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    209    209            y           2604    42368    foret id    DEFAULT     d   ALTER TABLE ONLY public.foret ALTER COLUMN id SET DEFAULT nextval('public.foret_id_seq'::regclass);
 7   ALTER TABLE public.foret ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    213    213            {           2604    42389    foret_type_arbre id    DEFAULT     z   ALTER TABLE ONLY public.foret_type_arbre ALTER COLUMN id SET DEFAULT nextval('public.foret_type_arbre_id_seq'::regclass);
 B   ALTER TABLE public.foret_type_arbre ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            u           2604    42316    ile id    DEFAULT     `   ALTER TABLE ONLY public.ile ALTER COLUMN id SET DEFAULT nextval('public.ile_id_seq'::regclass);
 5   ALTER TABLE public.ile ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            s           2604    42300 	   joueur id    DEFAULT     f   ALTER TABLE ONLY public.joueur ALTER COLUMN id SET DEFAULT nextval('public.joueur_id_seq'::regclass);
 8   ALTER TABLE public.joueur ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            z           2604    42381    type_arbre id    DEFAULT     n   ALTER TABLE ONLY public.type_arbre ALTER COLUMN id SET DEFAULT nextval('public.type_arbre_id_seq'::regclass);
 <   ALTER TABLE public.type_arbre ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            |           2604    42407    type_batiment id    DEFAULT     t   ALTER TABLE ONLY public.type_batiment ALTER COLUMN id SET DEFAULT nextval('public.type_batiment_id_seq'::regclass);
 ?   ALTER TABLE public.type_batiment ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218    219            ~           2604    42433    type_espace_naturel id    DEFAULT     ?   ALTER TABLE ONLY public.type_espace_naturel ALTER COLUMN id SET DEFAULT nextval('public.type_espace_naturel_id_seq'::regclass);
 E   ALTER TABLE public.type_espace_naturel ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    223    223            +          0    42305    archipel 
   TABLE DATA           D   COPY public.archipel (id, nom, localisation, id_joueur) FROM stdin;
    public          postgres    false    203   kw       =          0    42412    batiment 
   TABLE DATA           E   COPY public.batiment (id, nom, id_ile, id_type_batiment) FROM stdin;
    public          postgres    false    221   *x       /          0    42326    cinema 
   TABLE DATA           @   COPY public.cinema (id, nom, nombre_places, id_ile) FROM stdin;
    public          postgres    false    207   ?x       3          0    42347    cinema_film 
   TABLE DATA           =   COPY public.cinema_film (id, id_cinema, id_film) FROM stdin;
    public          postgres    false    211   y       A          0    42438    espace_naturel 
   TABLE DATA           Q   COPY public.espace_naturel (id, nom, id_ile, id_type_espace_naturel) FROM stdin;
    public          postgres    false    225   dy       1          0    42339    film 
   TABLE DATA           )   COPY public.film (id, titre) FROM stdin;
    public          postgres    false    209   ?y       5          0    42365    foret 
   TABLE DATA           <   COPY public.foret (id, nom, superficie, id_ile) FROM stdin;
    public          postgres    false    213   mz       9          0    42386    foret_type_arbre 
   TABLE DATA           G   COPY public.foret_type_arbre (id, id_foret, id_type_arbre) FROM stdin;
    public          postgres    false    217   ?z       -          0    42313    ile 
   TABLE DATA           A   COPY public.ile (id, nom, localisation, id_archipel) FROM stdin;
    public          postgres    false    205   ?z       )          0    42297    joueur 
   TABLE DATA           7   COPY public.joueur (id, nom, prenom, mail) FROM stdin;
    public          postgres    false    201   ?{       7          0    42378 
   type_arbre 
   TABLE DATA           1   COPY public.type_arbre (id, libelle) FROM stdin;
    public          postgres    false    215   M|       ;          0    42404    type_batiment 
   TABLE DATA           4   COPY public.type_batiment (id, libelle) FROM stdin;
    public          postgres    false    219   ?|       ?          0    42430    type_espace_naturel 
   TABLE DATA           :   COPY public.type_espace_naturel (id, libelle) FROM stdin;
    public          postgres    false    223   ?|       U           0    0    archipel_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.archipel_id_seq', 18, true);
          public          postgres    false    202            V           0    0    batiment_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.batiment_id_seq', 19, true);
          public          postgres    false    220            W           0    0    cinema_film_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.cinema_film_id_seq', 18, true);
          public          postgres    false    210            X           0    0    cinema_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.cinema_id_seq', 8, true);
          public          postgres    false    206            Y           0    0    espace_naturel_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.espace_naturel_id_seq', 4, true);
          public          postgres    false    224            Z           0    0    film_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.film_id_seq', 16, true);
          public          postgres    false    208            [           0    0    foret_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.foret_id_seq', 3, true);
          public          postgres    false    212            \           0    0    foret_type_arbre_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.foret_type_arbre_id_seq', 5, true);
          public          postgres    false    216            ]           0    0 
   ile_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.ile_id_seq', 26, true);
          public          postgres    false    204            ^           0    0    joueur_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.joueur_id_seq', 21, true);
          public          postgres    false    200            _           0    0    type_arbre_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.type_arbre_id_seq', 3, true);
          public          postgres    false    214            `           0    0    type_batiment_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.type_batiment_id_seq', 2, true);
          public          postgres    false    218            a           0    0    type_espace_naturel_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.type_espace_naturel_id_seq', 1, true);
          public          postgres    false    222            ?           2606    42310    archipel archipel_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.archipel
    ADD CONSTRAINT archipel_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.archipel DROP CONSTRAINT archipel_pkey;
       public            postgres    false    203            ?           2606    42417    batiment batiment_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.batiment
    ADD CONSTRAINT batiment_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.batiment DROP CONSTRAINT batiment_pkey;
       public            postgres    false    221            ?           2606    42352    cinema_film cinema_film_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cinema_film
    ADD CONSTRAINT cinema_film_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.cinema_film DROP CONSTRAINT cinema_film_pkey;
       public            postgres    false    211            ?           2606    42331    cinema cinema_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cinema
    ADD CONSTRAINT cinema_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cinema DROP CONSTRAINT cinema_pkey;
       public            postgres    false    207            ?           2606    42443 "   espace_naturel espace_naturel_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.espace_naturel
    ADD CONSTRAINT espace_naturel_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.espace_naturel DROP CONSTRAINT espace_naturel_pkey;
       public            postgres    false    225            ?           2606    42344    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    209            ?           2606    42370    foret foret_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.foret
    ADD CONSTRAINT foret_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.foret DROP CONSTRAINT foret_pkey;
       public            postgres    false    213            ?           2606    42391 &   foret_type_arbre foret_type_arbre_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.foret_type_arbre
    ADD CONSTRAINT foret_type_arbre_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.foret_type_arbre DROP CONSTRAINT foret_type_arbre_pkey;
       public            postgres    false    217            ?           2606    42318    ile ile_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.ile
    ADD CONSTRAINT ile_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.ile DROP CONSTRAINT ile_pkey;
       public            postgres    false    205            ?           2606    42302    joueur joueur_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.joueur
    ADD CONSTRAINT joueur_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.joueur DROP CONSTRAINT joueur_pkey;
       public            postgres    false    201            ?           2606    42383    type_arbre type_arbre_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.type_arbre
    ADD CONSTRAINT type_arbre_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.type_arbre DROP CONSTRAINT type_arbre_pkey;
       public            postgres    false    215            ?           2606    42409     type_batiment type_batiment_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.type_batiment
    ADD CONSTRAINT type_batiment_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.type_batiment DROP CONSTRAINT type_batiment_pkey;
       public            postgres    false    219            ?           2606    42435 ,   type_espace_naturel type_espace_naturel_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.type_espace_naturel
    ADD CONSTRAINT type_espace_naturel_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.type_espace_naturel DROP CONSTRAINT type_espace_naturel_pkey;
       public            postgres    false    223            ?           2606    42465     archipel archipel_id_joueur_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.archipel
    ADD CONSTRAINT archipel_id_joueur_fkey FOREIGN KEY (id_joueur) REFERENCES public.joueur(id) ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.archipel DROP CONSTRAINT archipel_id_joueur_fkey;
       public          postgres    false    203    201    3201            ?           2606    42475    batiment batiment_id_ile_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.batiment
    ADD CONSTRAINT batiment_id_ile_fkey FOREIGN KEY (id_ile) REFERENCES public.ile(id) ON DELETE CASCADE;
 G   ALTER TABLE ONLY public.batiment DROP CONSTRAINT batiment_id_ile_fkey;
       public          postgres    false    205    3205    221            ?           2606    42423 '   batiment batiment_id_type_batiment_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.batiment
    ADD CONSTRAINT batiment_id_type_batiment_fkey FOREIGN KEY (id_type_batiment) REFERENCES public.type_batiment(id);
 Q   ALTER TABLE ONLY public.batiment DROP CONSTRAINT batiment_id_type_batiment_fkey;
       public          postgres    false    221    219    3219            ?           2606    42490 &   cinema_film cinema_film_id_cinema_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cinema_film
    ADD CONSTRAINT cinema_film_id_cinema_fkey FOREIGN KEY (id_cinema) REFERENCES public.cinema(id) ON DELETE CASCADE;
 P   ALTER TABLE ONLY public.cinema_film DROP CONSTRAINT cinema_film_id_cinema_fkey;
       public          postgres    false    211    207    3207            ?           2606    42358 $   cinema_film cinema_film_id_film_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cinema_film
    ADD CONSTRAINT cinema_film_id_film_fkey FOREIGN KEY (id_film) REFERENCES public.film(id);
 N   ALTER TABLE ONLY public.cinema_film DROP CONSTRAINT cinema_film_id_film_fkey;
       public          postgres    false    209    211    3209            ?           2606    42470    cinema cinema_id_ile_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cinema
    ADD CONSTRAINT cinema_id_ile_fkey FOREIGN KEY (id_ile) REFERENCES public.ile(id) ON DELETE CASCADE;
 C   ALTER TABLE ONLY public.cinema DROP CONSTRAINT cinema_id_ile_fkey;
       public          postgres    false    207    3205    205            ?           2606    42485 )   espace_naturel espace_naturel_id_ile_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.espace_naturel
    ADD CONSTRAINT espace_naturel_id_ile_fkey FOREIGN KEY (id_ile) REFERENCES public.ile(id) ON DELETE CASCADE;
 S   ALTER TABLE ONLY public.espace_naturel DROP CONSTRAINT espace_naturel_id_ile_fkey;
       public          postgres    false    225    205    3205            ?           2606    42449 9   espace_naturel espace_naturel_id_type_espace_naturel_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.espace_naturel
    ADD CONSTRAINT espace_naturel_id_type_espace_naturel_fkey FOREIGN KEY (id_type_espace_naturel) REFERENCES public.type_espace_naturel(id);
 c   ALTER TABLE ONLY public.espace_naturel DROP CONSTRAINT espace_naturel_id_type_espace_naturel_fkey;
       public          postgres    false    225    223    3223            ?           2606    42480    foret foret_id_ile_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.foret
    ADD CONSTRAINT foret_id_ile_fkey FOREIGN KEY (id_ile) REFERENCES public.ile(id) ON DELETE CASCADE;
 A   ALTER TABLE ONLY public.foret DROP CONSTRAINT foret_id_ile_fkey;
       public          postgres    false    3205    213    205            ?           2606    42495 /   foret_type_arbre foret_type_arbre_id_foret_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.foret_type_arbre
    ADD CONSTRAINT foret_type_arbre_id_foret_fkey FOREIGN KEY (id_foret) REFERENCES public.foret(id) ON DELETE CASCADE;
 Y   ALTER TABLE ONLY public.foret_type_arbre DROP CONSTRAINT foret_type_arbre_id_foret_fkey;
       public          postgres    false    3213    213    217            ?           2606    42397 4   foret_type_arbre foret_type_arbre_id_type_arbre_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.foret_type_arbre
    ADD CONSTRAINT foret_type_arbre_id_type_arbre_fkey FOREIGN KEY (id_type_arbre) REFERENCES public.type_arbre(id);
 ^   ALTER TABLE ONLY public.foret_type_arbre DROP CONSTRAINT foret_type_arbre_id_type_arbre_fkey;
       public          postgres    false    215    3215    217            ?           2606    42319    ile ile_id_archipel_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.ile
    ADD CONSTRAINT ile_id_archipel_fkey FOREIGN KEY (id_archipel) REFERENCES public.archipel(id);
 B   ALTER TABLE ONLY public.ile DROP CONSTRAINT ile_id_archipel_fkey;
       public          postgres    false    205    203    3203            +   ?   x?5?=nA?k?)8 ??<?gݦH?D?H?fEFa?A??}?K.?]!?????!???????z'??E?!??n7y??S??*!A????o?+?l"ʡۍn?????b$	F?k뻿??T???VP??3?Wr\RdQ	?SNp:?{ƄB??[???O??	'??M^#???R???4?      =   ?   x?U?1!?z?vVa?4j???+?	?D!.?9???K???????	?@C	Gʦ??
>???h??آ??SH???$8?[?d;]?HiDgr>ϮD)?b??}Pr?bGcȺ?xE?bWQ?(*?e?e???
v&<?@???{xI?m??_P?F?      /   0   x?3?H,?8????ԀӒ˂?'?X??$?3'???(fh????? ?g
<      3   ?   x?ʹ !A[??'ȅ??8??Ngd?q????fR????4?дՖ???Di:v?>??ZI      A   ,   x?3?tN?+)J?I???4?2?t/J,?<??(??? (???? ??	?      1   ?   x???;?0????[@?<$F??X**????Ј?7??Ӱ?5z1bAta???????d?`??'???&Z(gs?0s?4qb??ȣ?8/?q?J??)~%aɺrֆ???z?[iAĭQW??$??1?%ъ???Ӣ?[}1j?????]ʤ????a?;?q??pMF??0?H?.???& &/Ű??+
v?      5   G   x?3????H???417????2?t??,VHI-VpI?M-?46?s''???''??p?X??%b???? ??      9   %   x?3?4?4?2?B.cNc ?Hq?Ic?=... Kg)      -   ?   x????
1???)ns??$m?ή>?K?"N?y???z??????H2?r???
ѻh???4?䴟?yf??4D/@?ñL?2?鼫???eDbX?}?H?$?7?B??h[????Xw]?Jo?׏???[ ?9???ӸO_3G?      )   ?   x?M?=?0????\tHH??\z~?????	?N?{??>2??*???*?l?x????3"?"??h'????$?}"??(B??3??(?J???a;k?3Y@%???iK?2?8?|??*2?y???r?l(?7??j(	??޳?a x2?pb>????[
      7   )   x?3?t?8?*/?ˈ??𪒢T.cN??Ҝ??R?=... ?[
0      ;       x?3??MLO,???2?<?29?'?+F??? a!      ?      x?3?,?ILO?????? ^?     