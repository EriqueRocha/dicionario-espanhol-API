-- Inserir dados na tabela "palavra_entity"
INSERT INTO public.palavra_entity (definicao, exemplo, genero, nome, nome_cientifico, nota_contrastiva)
VALUES ('Fruto do abacateiro, de forma ovalada, casca verde escura e relativamente dura. Sua polpa é amarelada e de sabor pouco doce e no seu interior se encontra uma grande e dura semente', 'Por lo general, el aguacate no se comercializa totalmente maduro', 'MASCULINO', 'ABACATE', 'persea americana', 'Em culturas hispano-americanas, o aguacate é usado na preparação de pratos salgados');

-- Inserir dados na tabela "palavra_entity_equivalentele"
INSERT INTO public.palavra_entity_equivalentele (palavra_entity_id, genero, nome)
VALUES (1, 'MASCULINO', 'AGUACATE');

-- Inserir dados na tabela "palavra_entity_resgistro_dicionariole"
INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (1, 'GDUEA', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (1, 'DLE23', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (1, 'MOLINER', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (1, 'DUEAE', 'SI');

-- Inserir dados na tabela "palavra_entity_resgistro_dicionariolp"
INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (1, 'HOUAISS', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (1, 'AURÉLIO', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (1, 'MICHAELIS', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (1, 'CALDASAULETE', 'SI');

-- Inserir dados na tabela "palavra_entity_variante_espanhol"
INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (1, 'DLE23', 'FEMININO', ARRAY['GT', 'EE', 'PE', 'BO', 'CH', 'AR', 'UR'], 'PALTA');

INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (1, 'MOLINER', 'FEMININO', ARRAY['AR', 'CH', 'PE', 'UR'], 'PALTA');

INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (1, 'DUEAE', 'FEMININO', ARRAY['AS'], 'PALTA');

INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (1, 'DLE23', 'FEMININO', ARRAY['CO', 'VE'], 'CURA');

INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (1, 'MOLINER', 'FEMININO', ARRAY['CO'], 'CURA');

-- Inserir dados na tabela "palavra_entity_variantelp"
INSERT INTO public.palavra_entity_variantelp (palavra_entity_id, dicionariolp, genero, nome)
VALUES (1, ARRAY['HOUAISS', 'MICHAELIS', 'CALDASAULETE'], 'MASCULINO', 'ABACATE');

INSERT INTO public.palavra_entity_variantelp (palavra_entity_id, dicionariolp, genero, nome)
VALUES (1, ARRAY['MICHAELIS'], 'FEMININO', 'PERA-DE-ADVOGADO');

-- Inserir dados na tabela "palavra_entity_image_paths"
INSERT INTO public.palavra_entity_image_paths (palavra_entity_id, image_paths)
VALUES (1, 'https://cdn.discordapp.com/attachments/721639814008406057/1174440402112237629/abacate.jpg?ex=656799db&is=655524db&hm=143c8ae4843bceddff53002590ba38b31e0efd355b6e03a76b6c498802a8d60b&');

-- ##################################################################

-- Inserir dados na tabela "palavra_entity"
INSERT INTO public.palavra_entity (definicao, exemplo, genero, nome, nome_cientifico, nota_contrastiva)
VALUES ('Fruto da aboboreira de variados formatos e texturas, de cores que vão do verde ao alaranjado, casca fina e dura, de polpa alaranjada relativamente dura com muitas sementes pequenas e achatadas.', 'Corta la calabaza en tacos pequeños, y ponla a cocer en agua con sal unos 10 o 15 minutos aproximadamente.', 'FEMININO', 'ABÓBORA', 'Cucurbita moschata Duch. Cucurbita maxima Duch.', NULL);

-- Inserir dados na tabela "palavra_entity_equivalentele"
INSERT INTO public.palavra_entity_equivalentele (palavra_entity_id, genero, nome)
VALUES (2, 'FEMININO', 'CALABAZA');

-- Inserir dados na tabela "palavra_entity_resgistro_dicionariole"
INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (2, 'GDUEA', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (2, 'DLE23', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (2, 'MOLINER', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (2, 'DUEAE', 'SI');

-- Inserir dados na tabela "palavra_entity_resgistro_dicionariolp"
INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (2, 'HOUAISS', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (2, 'AURÉLIO', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (2, 'MICHAELIS', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (2, 'CALDASAULETE', 'SI');

-- Inserir dados na tabela "palavra_entity_variante_espanhol"
INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (2, 'DLE23', 'FEMININO', ARRAY['AR', 'CL', 'CO', 'EC', 'ES', 'GT', 'HN', 'MX', 'PE', 'SV', 'UY', 'VE'], 'CALABAZA');

-- Inserir dados na tabela "palavra_entity_variantelp"
INSERT INTO public.palavra_entity_variantelp (palavra_entity_id, dicionariolp, genero, nome)
VALUES (2, ARRAY['HOUAISS'], 'FEMININO', 'ABOBRA');

INSERT INTO public.palavra_entity_variantelp (palavra_entity_id, dicionariolp, genero, nome)
VALUES (2, ARRAY['HOUAISS', 'MICHAELIS', 'CALDASAULETE'], 'MASCULINO', 'JERIMU');

INSERT INTO public.palavra_entity_variantelp (palavra_entity_id, dicionariolp, genero, nome)
VALUES (2, ARRAY['HOUAISS', 'AURÉLIO', 'MICHAELIS', 'CALDASAULETE'], 'MASCULINO', 'JERIMUM');

-- Inserir dados na tabela "palavra_entity_image_paths"
INSERT INTO public.palavra_entity_image_paths (palavra_entity_id, image_paths)
VALUES (2, 'https://cdn.discordapp.com/attachments/721639814008406057/1174440402456162313/abobora.jpg?ex=656799db&is=655524db&hm=2129b6f85de3058af305136498e3a7bcbdaf73ddd07707589d01026f3e621518&');

--##########################################################################
-- Inserir dados na tabela "palavra_entity"
INSERT INTO public.palavra_entity (definicao, exemplo, genero, nome, nome_cientifico, nota_contrastiva)
VALUES ('Fruto da algarobeira em forma de vagem, de cor negro avermelhado, polpa branca e doce que abriga suas sementes negras e lisas.', 'En periodos de escasez de alimentos, las algarrobas han sido una fuente energética importante.', 'FEMININO', 'ALGAROBA', 'Prosopis juliflora (Sw.) DC', NULL);

-- Inserir dados na tabela "palavra_entity_equivalentele"
INSERT INTO public.palavra_entity_equivalentele (palavra_entity_id, genero, nome)
VALUES (3, 'FEMININO', 'ALGARROBA');

-- Inserir dados na tabela "palavra_entity_resgistro_dicionariole"
INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (3, 'GDUEA', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (3, 'DLE23', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (3, 'MOLINER', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (3, 'DUEAE', 'SI');

-- Inserir dados na tabela "palavra_entity_resgistro_dicionariolp"
INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (3, 'HOUAISS', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (3, 'AURÉLIO', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (3, 'MICHAELIS', 'NOa');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (3, 'CALDASAULETE', 'NOa');

-- Inserir dados na tabela "palavra_entity_variante_espanhol"
INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (3, 'GDUEA', 'FEMININO', NULL, 'GARROBA');

INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (3, 'GDUEA', 'FEMININO', NULL, 'GARROFA');

INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (3, 'DUEAE', 'FEMININO', NULL, 'ARVEJA');

INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (3, 'DUEAE', 'FEMININO', NULL, 'VICIA');

INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (3, 'MOLINER', 'FEMININO', NULL, 'ALGARROBINA');

-- Inserir dados na tabela "palavra_entity_variantelp"
INSERT INTO public.palavra_entity_variantelp (palavra_entity_id, dicionariolp, genero, nome)
VALUES (3, ARRAY['AURÉLIO'], 'FEMININO', 'ALFARROBA');

-- Inserir dados na tabela "palavra_entity_image_paths"
INSERT INTO public.palavra_entity_image_paths (palavra_entity_id, image_paths)
VALUES (3, 'https://cdn.discordapp.com/attachments/721639814008406057/1174440402829463552/algaroba.jpg?ex=656799dc&is=655524dc&hm=c16bacff4792f7165f1ab4ea5e508501cdcfeda15dbb0a3828d8ac0b24d97987&');

--####################################################################

-- Inserir dados na tabela "palavra_entity"
INSERT INTO public.palavra_entity (definicao, exemplo, genero, nome, nome_cientifico, nota_contrastiva)
VALUES ('Fruto do abacaxizeiro de forma cônica, de casca verde amarelada rugosa e áspera com um penacho de folhas duras espinhosas no topo. Sua polpa é doce e carnosa de cor amarelada sem sementes.', 'El tallo de ananás ayuda a digerir, aportando una cantidad importante de bromelaína.', 'MASCULINO', 'ABACAXI-DO-CERRADO', 'Ananas ananassoides', 'Abacaxi-do-cerrado é um tipo de abacaxi, em espanhol não há distinção entre eles: ananás. Ainda que exista a forma abacaxi, em hispanoamérica se usa com maior frequência piña.');

-- Inserir dados na tabela "palavra_entity_equivalentele"
INSERT INTO public.palavra_entity_equivalentele (palavra_entity_id, genero, nome)
VALUES (4, 'MASCULINO', 'ANANÁS');

-- Inserir dados na tabela "palavra_entity_resgistro_dicionariole"
INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (4, 'GDUEA', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (4, 'DLE23', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (4, 'MOLINER', 'SI');

INSERT INTO public.palavra_entity_resgistro_dicionariole (palavra_entity_id, dicionariole, presenca)
VALUES (4, 'DUEAE', 'SI');

-- Inserir dados na tabela "palavra_entity_resgistro_dicionariolp"
INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (4, 'HOUAISS', 'NO');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (4, 'AURÉLIO', 'NOa');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (4, 'MICHAELIS', 'NO');

INSERT INTO public.palavra_entity_resgistro_dicionariolp (palavra_entity_id, dicionariolp, presenca)
VALUES (4, 'CALDASAULETE', 'NO');

-- Inserir dados na tabela "palavra_entity_variante_espanhol"
INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (4, 'DLE23', 'FEMININO', ARRAY['AM'], 'PIÑA');

INSERT INTO public.palavra_entity_variante_espanhol (palavra_entity_id, dicionariole, genero, paises, palavra)
VALUES (4, 'DLE23', 'MASCULINO', ARRAY['AR','UR'], 'ABACACHÍ/ABACAXÍ');

-- Inserir dados na tabela "palavra_entity_variantelp"
INSERT INTO public.palavra_entity_variantelp (palavra_entity_id, dicionariolp, genero, nome)
VALUES (4, ARRAY[NULL], NULL, NULL);

-- Inserir dados na tabela "palavra_entity_image_paths"
INSERT INTO public.palavra_entity_image_paths (palavra_entity_id, image_paths)
VALUES (4, 'https://cdn.discordapp.com/attachments/721639814008406057/1175545801846562907/abacaxi.jpg?ex=656b9f57&is=65592a57&hm=91c55065df1c837c34637224c9e69aa5dea881fdf3ba3463dbf80c25fdd9651a&');

