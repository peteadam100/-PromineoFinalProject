INSERT INTO users (first_name, last_name, username) VALUES ('Bob', 'Dole', 'Dole Head');
INSERT INTO users (first_name, last_name, username) VALUES ('Jane', 'Doe', 'Janester');
INSERT INTO users (first_name, last_name, username) VALUES ('Samuel', 'Smith', 'casanova');
INSERT INTO users (first_name, last_name, username) VALUES ('Temperance', 'Johnson', 'YESIMFUNNY');
INSERT INTO users (first_name, last_name, username) VALUES ('Vitoria', 'Gonzalez', 'nugget');
INSERT INTO users (first_name, last_name, username) VALUES ('William', 'Baker', 'Boop Your Nose');
INSERT INTO users (first_name, last_name, username) VALUES ('Jacob', 'Powell', 'Bud Lightyear');
INSERT INTO users (first_name, last_name, username) VALUES ('Jasmine', 'Summers', 'InstaPrincess');







-- Idaho trivia game
-- -----------------------------------------------------------------------
INSERT INTO games (game_name, game_description, available_date_time, lock_date_time) VALUES ('Idaho Trivia', 'Trivia questions about the stat of idaho', NULL, NULL);

INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 1, 'What is Idaho\'s state capital?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 2, 'What is the state of Idaho\'s nickname?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 3, 'What is the Idaho State Amphibian?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 4, 'Where does the US State of Idaho rank among the rest of the US States as far as the size of its population?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 5, 'Idaho shares a border with what Canadian province?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 6, 'What is the official Idaho State Bird?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 7, 'The Port of Lewiston is the farthest inland seaport on the West Coast at how many  river miles from the Pacific Ocean? ');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 8, 'What is the point with highest elevation in the state of Idaho?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 9, 'What is the official Idaho State Fish?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 10, 'What city is the state\'s largest?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 11, 'Which two states border Idaho to the south?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 12, 'What is the Idaho State Fruit? ');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 13, 'Where is Idaho\'s lowest point at  710 ft?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 14, 'Where does the state of Idaho rank among the US States in size?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 15, 'The state of Idaho borders how many US states? ');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 16, 'What is the Idaho State Insect?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 17, 'What is Idaho\'s all-time highest temperature?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 18, 'According to the Census Bureau the population of Idaho was how many people on July 1, 2013?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 19, 'What is the Idaho State Raptor?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 20, 'What is the official Idaho State Gem?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 21, 'What is the name of Idaho\'s second largest city?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 22, 'Where is the world\'s largest factory for barrel cheese located? ');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 23, 'Where in Idaho was the world\'s first chairlift was installed in 1936?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 24, 'Which two US states are on the western border of Idaho? ');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 25, 'What is Idaho\'s all-time lowest temperature? ');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 26, 'What is the Idaho State Tree?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 27, 'On what date was the state of Idaho admitted to the Union?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 28, 'What was the name of the first non-indigenous settlement in what is now Idaho?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 29, 'Idaho produces what share of the potatoes grown in the United States?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 30, 'What is the Idaho State Dance?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 31, 'The Frank Church-River of No Return Wilderness Area is the largest contiguous area of protected wilderness in the continental United States with how big of an area in acres?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 32, 'Idaho is one of only two places on the planet where you can find star garnets significant quantities. Where is the other place?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 33, 'How big is the state of Idaho in square miles? ');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (1, 34, 'How many counties does the state of Idaho have?');



INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (1, 1, 'IDAHO FALLS', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (1, 2, 'LEWISTON', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (1, 3, 'BOISE', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (1, 4, 'NAMPA', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (2, 1, 'The Big Sky state', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (2, 2, 'The Sapphire State', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (2, 3, 'The Wilderness State', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (2, 4, 'The Gem State', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (2, 1, 'Red Hills Salamander', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (3, 2, 'Leopard Frog', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (3, 3, 'Tiger salamander', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (3, 4, 'None of the above', FALSE);


INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (4, 1, '42nd', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (4, 2, '29th', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (4, 3, '33rd', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (4, 4, '39th', TRUE);


INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (5, 1, 'Ontario', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (5, 2, 'British Columbia', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (5, 3, 'Alberta', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (5, 4, 'Saskatchewan', FALSE);


INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (6, 1, 'Blue Hen Chicken', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (6, 2, 'Mountain Bluebird', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (6, 3, 'Western Meadowlark', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (6, 4, 'Hermit Thrush', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (7, 1, '375', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (7, 2, '405', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (7, 3, '465', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (7, 4, '525', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (8, 1, 'Snake Mountain', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (8, 2, 'White Cloud Mountain', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (8, 3, 'Borath Peak', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (8, 4, 'Salmon Ridge', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (9, 1, 'Idaho Golden Trout', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (9, 2, 'Large Mouth Bass', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (9, 3, 'Channel Catfish', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (9, 4, 'Cutthroat Trout', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (10, 1, 'Idaho Falls', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (10, 2, 'Pocatello', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (10, 3, 'Lewiston', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (10, 4, 'Boise', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (11, 1, 'California and Arizona', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (11, 2, 'Utah and New Mexico', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (11, 3, 'Nevada and Oregon', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (11, 4, 'Nevada and Utah', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (12, 1, 'Blackberry', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (12, 2, 'Huckleberry', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (12, 3, 'Boysenberry', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (12, 4, 'Raspberry', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (13, 1, 'In Cedar Falls', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (13, 2, 'Southern Border', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (13, 3, 'Falls Church', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (13, 4, 'In Lewiston', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (14, 1, 'It\'s the 9th Largest', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (14, 2, 'It\'s the 22nd Largest', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (14, 3, 'It\'s the 31st Largest', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (14, 4, 'It\'s the 14th Largest', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (15, 1, '3', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (15, 2, '4', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (15, 3, '5', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (15, 4, '6', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (16, 1, 'Firefly', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (16, 2, 'Monarch butterfly', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (16, 3, 'Mourning cloak butterfly', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (16, 4, 'Tiger swallow butterfly', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (17, 1, '118 °F', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (17, 2, '109 °F', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (17, 3, '120 °F', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (17, 4, '114 °F', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (18, 1, '1,612,136', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (18, 2, '2,263,155', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (18, 3, '1,895,632', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (18, 4, '1,415,264', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (19, 1, 'Golden Eagle', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (19, 2, 'Osprey', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (19, 3, 'Peregrine falcon', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (19, 4, 'Red-tailed Hawk', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (20, 1, 'Idaho star garnet', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (20, 2, 'Idaho star sapphire', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (20, 3, 'Amethyst', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (20, 4, 'Rose Quartz', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (21, 1, 'Lewiston', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (21, 2, 'Cedar Falls', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (21, 3, 'Boise', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (21, 4, 'Nampa', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (22, 1, 'Nampa', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (22, 2, 'Gooding', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (22, 3, 'Boise', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (22, 4, 'Wallace', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (23, 1, 'Hells Canyon', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (23, 2, 'Bear Lake', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (23, 3, 'Borah Peak', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (23, 4, 'Sun Valley', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (24, 1, 'Montana and Wyoming', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (24, 2, 'Washington and Oregon', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (24, 3, 'Washington and Montana', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (24, 4, 'Nevada and California', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (25, 1, '-47 °F', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (25, 2, '-51 °F', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (25, 3, '-63 °F', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (25, 4, '-60 °F', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (26, 1, 'Plains Cottonwood', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (26, 2, 'White Oak Tree', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (26, 3, 'American Elm', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (26, 4, 'Western White Pine', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (27, 1, 'July 9, 1890', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (27, 2, 'July 3, 1891', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (27, 3, 'July 3, 1890', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (27, 4, 'July 9, 1889', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (28, 1, 'Lewiston', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (28, 2, 'Cedar Rapids', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (28, 3, 'Kullyspell House', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (28, 4, 'Boise', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (29, 1, 'Almost one-half', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (29, 2, 'Nearly one-third', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (29, 3, 'About three-quarters', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (29, 4, 'None of the above', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (30, 1, 'Line Dance', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (30, 2, 'Waltz', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (30, 3, 'Square Dance', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (30, 4, 'Two Step', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (31, 1, '1.3 million', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (31, 2, '1.8 miollion', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (31, 3, '2.3 million', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (31, 4, '2.8 million', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (32, 1, 'India', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (32, 2, 'New Mexico', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (32, 3, 'Serbia', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (32, 4, 'South Africa', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (33, 1, '83,570 sq. mi', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (33, 2, '88,454 sq. mi', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (33, 3, '81,125 sq. mi', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (33, 4, '78,267 sq. mi', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (34, 1, '37', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (34, 2, '39', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (34, 3, '44', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (34, 4, '46', TRUE);







-- Movies game
-- -----------------------------------------------------------------------------
INSERT INTO games (game_name, game_description, available_date_time, lock_date_time) VALUES ('Movies', 'Movie trivia', NULL, NULL);

INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 1, 'The Moon of Barods, a diamond that Marilyn Monroe wore when singing "Diamonds Are A Girl\'s Best Friend" in the film Gentlemen prefer Blondes, was auctioned off at Christies for how much in 1990?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 2, 'Which one of these Academy Awards did Gone With the Wind not win?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 3, 'Which one of these talented actors did not star in the 1989 movie "Family Business"?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 4, 'In the 1933 movie where May West spoke the line "Come up and see me sometime" , called She Done Him Wrong, who was her co-star?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 5, 'Clint Eastwood gave us the immortal line, "Go ahead... make my day", in what film?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 6, 'In the 1951 science fiction movie, The Day The Earth Stood Still, what was the name of the robot?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 7, 'Jack Walsh and Jonathan Mardukas  are the names of the two main characters in what movie?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 8, 'What is the film crew\'s chief electrician called?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 9, 'After winning the 1988 Oscar, who said "I never thought I\'d have a nomination... I never thought anybody ever took any of my pictures seriously"?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 10, 'In the 1946 movie "The She-Wolf of London", who played the title role?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 11, 'In the Dirty Harry movies starring Clint Eastwood as Dirty Harry, what was Harry\'s last name?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 12, 'Blondie\'s " Call Me" , a number one hit for her, was the theme song of which film?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 13, 'How much of his own money did Francis Ford Coppola put up to finish the movie  "Apocalypse Now" when it ran wildly over budget?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 14, 'What was the name of the last movie that John Wayne appeared in?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 15, 'In the Friday the 13th movies, what is the name of the masked killer?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 16, 'What  1987 film was based on a novel called The Short Timers by Gustav Hasford?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 17, 'Which of the following actors has the middle name "DeForest"?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 18, 'What was the name of the island on which King Kong was discovered in the original 1933 movie?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 19, 'In the movie Who Framed Roger Rabbit, which pair of genetically similar characters perform a piano duet?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (2, 20, 'Julie Andrews won the Academy Award for  best actress in what film?');


INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (35, 1, '97,000', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (35, 2, '297,000', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (35, 3, '497,000', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (35, 4, '797,000', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (36, 1, 'best actor', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (36, 2, 'best actress', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (36, 3, 'best picture', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (36, 4, 'best supporting actor', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (37, 1, 'Sean Connery', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (37, 2, 'Matthew Broderick', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (37, 3, 'Dustin Hoffman', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (37, 4, 'Tom Cruise', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (38, 1, 'W.C. Fields', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (38, 2, 'Cary Grant', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (38, 3, 'James Stewart', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (38, 4, 'John Wayne', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (39, 1, 'Dirty Harry', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (39, 2, 'Magnum Force', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (39, 3, 'Sudden Impact', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (39, 4, 'Tightrope', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (40, 1, 'Gort', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (40, 2, 'Klaatu', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (40, 3, 'Robby', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (41, 1, 'Midnight Cowboy', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (41, 2, 'Midnight Express', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (41, 3, 'Midnight Run', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (42, 1, 'Big L', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (42, 2, 'Gaffer', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (42, 3, 'Sparks', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (43, 1, 'Cher', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (43, 2, 'Jodie Foster', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (43, 3, 'Shirley Maclaine', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (44, 1, 'Eva Gabor', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (44, 2, 'Boris Karloff', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (44, 3, 'June Lockhart', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (45, 1, 'Callahan', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (45, 2, 'Flint', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (45, 3, 'Harrigan', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (45, 4, 'Steele', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (46, 1, 'American Gigolo', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (46, 2, 'An Officer and a Gentleman', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (46, 3, 'Sorry, Wrong Number', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (47, 1, '$1 million', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (47, 2, '$6 million', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (47, 3, '$16 million', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (47, 4, '$25 million', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (48, 1, 'The Green Berets', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (48, 2, 'The Shootist', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (48, 3, 'True Grit', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (49, 1, 'Freddy', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (49, 2, 'Jason', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (49, 3, 'He has no name', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (50, 1, 'Angel Heart', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (50, 2, 'Broadcast News', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (50, 3, 'Fatal Attraction', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (50, 4, 'Full Metal Jacket', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (51, 1, 'Humphrey Bogart', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (51, 2, 'James Cagney', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (51, 3, 'Clint Eastwood', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (51, 4, 'Burt Lancaster', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (52, 1, 'Ape Island', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (52, 2, 'Borneo', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (52, 3, 'Monster Island', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (52, 4, 'Skull Island', TRUE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (53, 1, 'Bambi and Bullwinkle', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (53, 2, 'Donald Duck and Daffy Duck', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (53, 3, 'Gafield and Sylvester', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (53, 4, 'Speedy Gonzales and Minnie Mouse', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (54, 1, 'Mary Poppins', TRUE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (54, 2, 'The Sound of Music', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (54, 3, 'Victor/Victoria', FALSE);










-- Movies game
-- -----------------------------------------------------------------------------
INSERT INTO games (game_name, game_description, available_date_time, lock_date_time) VALUES ('Superbowl Fun', 'Predict what events will happen in the superbowl', NULL, NULL);


INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 1, 'Which team do you think will win?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 2, 'Which team will win the coin toss?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 3, 'What kind of commercial will be the first commercial played after the coin toss?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 4, 'Which team will score first?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 5, 'How will the first team to score, score?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 6, 'Which player will score the first touchdown?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 7, 'Which team will lead at halftime?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 8, 'What will the first turnover be?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 9, 'Which team will commit the first turnover?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 10, 'Which team will score last?');
INSERT INTO questions (game_pk, question_order, question_text) VALUES (3, 11, 'Tie Breaker: How many points will be scored?');


INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (55, 1, 'Patriots', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (55, 2, 'Falcons', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (56, 1, 'Patriots', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (56, 2, 'Falcons', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer, special_notes) VALUES (57, 1, 'Soft goods', FALSE, 'Soft goods= “any products that are expected to have a life span of less than three years. Examples: Clothing, Sheets, Table Clothes, Napkins, Towels, Draperies, Curtains, Textiles"');
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (57, 1, 'Technology', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (57, 2, 'Beverage', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (57, 3, 'Food', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer, special_notes) VALUES (57, 1, 'Hard goods', FALSE, 'Hard goods= “Products that aren&#39;t consumed or quickly disposed of, and can be used for several years” Also called “Durable Goods” Examples: Cars, TVs, Household Appliances, Bricks, Furniture, Sports Equipment, Toys.');

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (58, 1, 'Patriots', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (58, 2, 'Falcons', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (59, 1, 'Safety', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (59, 2, 'Touchdown', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (59, 3, 'Field Goal', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (60, 1, 'Running Back', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (60, 2, 'Receiver', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer, special_notes) VALUES (60, 3, 'Quarterback', FALSE, 'Meaning the QB runs for the TD (not throwing it. If it’s a pass, even to the running back, it counts as a receiver, because he becomes a legal receiver).');
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (60, 4, 'Other', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (61, 1, 'Tied', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (61, 2, 'Patriots', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (61, 3, 'Falcons', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (62, 1, 'Interception', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (62, 2, 'Fumble', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer, special_notes) VALUES (62, 3, 'Downs (not a punt)', FALSE, 'When a team attempts to go for it on 4 th down and gets stopped. A punt is giving up the ball willing, and thus not considered a turnover. If you go for it, you are hoping to get it, not intending to give it to the other team.');
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (62, 4, 'No Turnovers', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (63, 1, 'Patriots', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (63, 2, 'Falcons', FALSE);

INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (64, 1, 'Patriots', FALSE);
INSERT INTO answers (question_pk, answer_order, answer, is_correct_answer) VALUES (64, 2, 'Falcons', FALSE);






