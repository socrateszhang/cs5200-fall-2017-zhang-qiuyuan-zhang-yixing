ALTER TABLE MOVIE DROP FOREIGN KEY FK_MOVIE_LIBRARY_ID
ALTER TABLE ACTOR DROP FOREIGN KEY FK_ACTOR_ID
ALTER TABLE DIRECTOR DROP FOREIGN KEY FK_DIRECTOR_ID
ALTER TABLE MOVIE2ACTOR DROP FOREIGN KEY FK_MOVIE2ACTOR_moviesActed_ID
ALTER TABLE MOVIE2ACTOR DROP FOREIGN KEY FK_MOVIE2ACTOR_actors_ID
ALTER TABLE MOVIE2DIRECTOR DROP FOREIGN KEY FK_MOVIE2DIRECTOR_moviesDirected_ID
ALTER TABLE MOVIE2DIRECTOR DROP FOREIGN KEY FK_MOVIE2DIRECTOR_directors_ID
DROP TABLE PERSON
DROP TABLE MOVIE
DROP TABLE MOVIELIBRARY
DROP TABLE ACTOR
DROP TABLE DIRECTOR
DROP TABLE MOVIE2ACTOR
DROP TABLE MOVIE2DIRECTOR
