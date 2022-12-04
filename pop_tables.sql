/*
Populating the tables
Starting with the projects and users, since they are the base for the entire project.
*/

/*
I'm pretty sure that there wouldn't be more than 30 projects, so I won't be adding more than 10
*/
Insert Into Project Values (1, 'California Rocks', '2022:08:09');
Insert Into Project Values (2, 'Rock Creek Gold', '2022:11:12');
Insert Into Project Values (3, 'Minerals and Trees', '2009:05:30');
Insert Into Project Values (4, 'Useless Minerals', '2013:04:10');
Insert Into Project Values (5, 'Ohio Agates', '1999:12:07');
Insert Into Project Values (6, 'Mundane Rocks', '2003:08:24');


/*
Adding 30 different users
*/
Insert Into User Values (1, 'rockyroad', '2014:01:13');
Insert Into User Values (2, 'unicorn123', '2011:08:10');
Insert Into User Values (3, 'jharwood', '2017:05:04');
Insert Into User Values (4, 'jbond', '2012:09:22');
Insert Into User Values (5, 'jdoe', '2011:03:29');

Insert Into User Values (6, 'greeneggs', '2003:01:13');
Insert Into User Values (7, 'ham', '2001:08:12');
Insert Into User Values (8, 'samiam', '2007:05:18');
Insert Into User Values (9, 'rainbowroad', '2002:09:30');
Insert Into User Values (10, 'rockhound', '2001:03:21');

Insert Into User Values (11, 'antsmite', '2019:01:24');
Insert Into User Values (12, 'elkworn89', '2017:08:24');
Insert Into User Values (13, 'jverne80', '2015:05:17');
Insert Into User Values (14, 'loopsand', '2012:09:28');
Insert Into User Values (15, 'yourtown', '2018:03:13');

Insert Into User Values (16, 'philosopher', '2019:01:15');
Insert Into User Values (17, 'plato', '2013:08:27');
Insert Into User Values (18, 'socrates', '2011:05:14');
Insert Into User Values (19, 'meno67', '2012:09:28');
Insert Into User Values (20, 'aristotle', '2013:03:28');

Insert Into User Values (21, 'attlerock', '2014:01:13');
Insert Into User Values (22, 'embertwin', '2015:08:10');
Insert Into User Values (23, 'ashtwin', '2016:05:04');
Insert Into User Values (24, 'timber_hearth', '2013:09:22');
Insert Into User Values (25, 'giantsdeep', '2018:03:29');

Insert Into User Values (26, 'gadfly', '2022:01:23');
Insert Into User Values (27, 'efromm', '2003:08:10');
Insert Into User Values (28, 'goldhunter', '2018:05:04');
Insert Into User Values (29, 'calihount', '2013:09:02');
Insert Into User Values (30, 'calhoun', '2014:03:12');

/*
The observation data was randomly generated
*/
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (11, 'Gold', FALSE, 84.843160, -137.615388, '2016:05:21', 25.96);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (10, 'Granite', TRUE, 14.511596, -23.919350, '2014:05:15', 109.59);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (16, 'Shale', TRUE, 82.024170, -41.307435, '2018:11:25', 2.34);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (5, 'Granite', TRUE, -49.777955, -141.309796, '2015:10:17', 66.64);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (11, 'Amethyst', FALSE, 16.482643, -173.915693, '2010:12:15', 127.54);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (4, 'Shale', TRUE, 23.325961, 22.431514, '2007:04:20', 23.03);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (6, 'Gold', TRUE, -84.597219, -137.640905, '2015:02:12', 61.49);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (15, 'Shale', TRUE, 16.134584, -82.242675, '2003:10:12', 51.30);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (13, 'Shale', TRUE, 29.772185, 103.054158, '2011:03:12', 193.66);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (4, 'Vanadanite', TRUE, 50.322634, 95.842937, '2016:06:08', 142.15);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (1, 'Amethyst', TRUE, 78.500293, -91.863663, '2014:05:17', 189.06);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (22, 'Diamond', TRUE, -63.134787, 0.036888, '2021:05:16', 132.44);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (6, 'Dirt', TRUE, 84.233197, -17.383175, '2018:12:19', 81.37);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (19, 'Shale', TRUE, 9.198720, -115.514605, '2017:01:17', 96.25);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (13, 'Agate', TRUE, -82.529692, 35.149240, '2011:07:08', 39.24);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (28, 'Amethyst', FALSE, 32.737026, -120.443506, '2003:03:17', 5.62);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (13, 'Quartz', TRUE, 68.913982, 16.236450, '2012:08:03', 147.81);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (15, 'Quartz', TRUE, 52.280971, 127.550878, '2018:05:07', 105.68);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (22, 'Lithite', TRUE, -82.403151, 32.153839, '2014:03:08', 77.45);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (26, 'Quartz', TRUE, -18.441857, 12.774299, '2001:11:11', 166.36);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (7, 'Granite', TRUE, -4.930036, 27.745691, '2012:05:23', 139.58);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (27, 'Gold', TRUE, -80.533075, -59.715675, '2012:12:11', 72.78);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (16, 'Berryl', TRUE, 58.588090, 11.742903, '2014:09:12', 182.93);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (15, 'Granite', TRUE, -21.629182, -157.613716, '2019:01:03', 136.95);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (13, 'Lithite', TRUE, 3.701695, 129.256961, '2003:11:09', 199.02);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (14, 'Granite', TRUE, -14.966900, 142.095006, '2010:12:25', 85.90);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (18, 'Granite', TRUE, 63.159006, 98.039299, '2013:04:02', 48.83);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (25, 'Agate', TRUE, -75.915288, 75.459733, '2006:05:09', 11.02);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (18, 'Quartz', TRUE, -57.265225, 48.369449, '2021:02:12', 7.32);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (12, 'Diamond', TRUE, 48.350956, 78.659738, '2009:06:18', 106.02);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (26, 'Quartz', TRUE, 57.762407, -66.791744, '2010:07:25', 198.56);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (8, 'Gold', TRUE, 54.446952, 166.308679, '2001:12:20', 63.41);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (10, 'Lithite', TRUE, 88.657391, -113.073677, '2009:06:27', 117.09);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (23, 'Quartz', TRUE, 57.196963, 81.537745, '2014:07:11', 64.40);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (3, 'Garnet', TRUE, -44.583249, 21.207423, '2006:01:17', 34.43);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (15, 'Garnet', TRUE, -69.929627, -164.577562, '2016:02:03', 27.78);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (19, 'Lithite', TRUE, -86.816498, 31.811209, '2001:02:22', 8.94);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (7, 'Granite', TRUE, 84.132692, -121.371348, '2011:07:08', 91.33);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (2, 'Dirt', TRUE, -52.261171, -21.299876, '2015:11:05', 32.20);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (15, 'Lithite', TRUE, -46.050178, -9.750001, '2007:03:04', 41.82);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (23, 'Amethyst', TRUE, 53.149570, -57.436870, '2001:08:06', 75.87);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (1, 'Tiger Quartz', TRUE, -28.746096, 152.314526, '2020:07:10', 69.74);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (7, 'Amethyst', TRUE, 0.332026, 0.975573, '2019:01:11', 73.47);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (19, 'Granite', FALSE, 21.708089, 28.316448, '2017:03:04', 111.28);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (7, 'Gold', TRUE, -46.848722, -155.223535, '2010:04:08', 118.93);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (4, 'Chalcedony', TRUE, -55.514869, -172.491364, '2004:05:12', 7.54);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (13, 'Dirt', TRUE, -0.351632, 149.534454, '2017:09:17', 150.19);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (13, 'Amethyst', TRUE, -60.399766, -39.377300, '2017:07:03', 80.45);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (17, 'Granite', TRUE, -80.359984, 24.876551, '2016:08:11', 175.06);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (12, 'Granite', TRUE, -45.910067, -28.276679, '2005:08:18', 22.75);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (18, 'Amethyst', TRUE, 62.747617, -44.757770, '2009:07:01', 35.19);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (20, 'Gold', FALSE, -40.629364, 179.493466, '2003:03:09', 140.35);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (3, 'Amethyst', TRUE, -23.017697, -146.022217, '2006:03:10', 9.54);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (12, 'Tiger Quartz', TRUE, -37.774756, -137.651976, '2013:08:15', 118.13);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (21, 'Amethyst', TRUE, 50.954837, -110.270425, '2000:01:02', 128.95);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (27, 'Quartz', TRUE, -22.950637, -40.281661, '2006:01:24', 21.91);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (26, 'Vanadanite', TRUE, -28.081089, -69.994844, '2009:04:27', 152.23);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (12, 'Chalcedony', TRUE, -27.108338, -143.520738, '2019:11:22', 65.33);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (14, 'Vanadanite', TRUE, -21.600793, -22.228484, '2021:03:10', 61.17);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (28, 'Opal', TRUE, -33.366276, -56.610564, '2011:10:08', 104.29);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (17, 'Diamond', TRUE, 78.172129, 110.463799, '2005:06:01', 96.44);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (10, 'Berryl', TRUE, -53.746266, 110.954385, '2007:04:05', 130.71);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (29, 'Granite', TRUE, -62.880665, -1.732265, '2014:04:12', 25.21);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (16, 'Gold', TRUE, -50.401051, -137.686418, '2003:09:16', 14.15);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (26, 'Gold', TRUE, -36.193617, 129.218309, '2015:12:08', 149.84);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (3, 'Amethyst', TRUE, 67.289672, -15.541571, '2008:10:20', 140.91);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (30, 'Garnet', TRUE, -74.932719, 32.868287, '2009:04:21', 7.76);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (3, 'Opal', TRUE, -82.481125, 75.549277, '2001:07:25', 17.81);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (14, 'Amethyst', TRUE, 20.713723, 3.960735, '2005:05:07', 76.37);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (9, 'Gold', TRUE, 40.933333, 151.530327, '2000:09:19', 198.50);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (18, 'Amethyst', TRUE, -76.647101, -95.958328, '2006:03:27', 134.89);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (24, 'Vanadanite', TRUE, 79.512311, 35.832594, '2005:04:21', 84.26);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (13, 'Shale', TRUE, -57.152390, 7.404732, '2020:03:13', 103.94);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (10, 'Quartz', TRUE, 52.813600, -80.905556, '2021:12:19', 67.49);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (30, 'Shale', TRUE, -75.307964, -103.116208, '2004:06:01', 140.54);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (23, 'Tiger Quartz', TRUE, -63.251268, 111.377473, '2015:10:24', 143.91);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (25, 'Shale', TRUE, 74.483840, 176.936408, '2020:10:21', 59.85);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (14, 'Amethyst', TRUE, -22.627021, 161.332552, '2004:05:20', 68.40);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (23, 'Dirt', TRUE, -2.123873, -19.856785, '2018:06:22', 117.47);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (20, 'Diamond', TRUE, -73.007134, -42.473006, '2013:01:28', 27.12);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (18, 'Tiger Quartz', TRUE, -60.955846, -139.444323, '2010:05:12', 95.56);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (6, 'Quartz', TRUE, -33.624359, 35.693695, '2001:05:24', 65.82);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (19, 'Garnet', TRUE, -45.104857, 84.839540, '2019:11:08', 171.34);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (7, 'Opal', TRUE, -29.991271, -131.716677, '2006:04:25', 40.17);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (21, 'Tiger Quartz', TRUE, -74.378768, -145.913004, '2000:09:15', 107.35);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (20, 'Granite', TRUE, -56.528793, 149.837780, '2018:11:01', 120.65);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (10, 'Diamond', TRUE, 87.608851, -149.074403, '2016:10:06', 83.23);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (23, 'Dirt', TRUE, 61.202289, 42.634348, '2000:04:13', 145.76);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (14, 'Amethyst', FALSE, -89.130865, 161.922225, '2002:07:02', 50.05);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (27, 'Diamond', TRUE, -15.425599, -150.527897, '2021:07:22', 53.36);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (8, 'Berryl', TRUE, -26.278089, -102.216273, '2002:08:13', 72.60);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (16, 'Quartz', TRUE, -49.772010, 11.042528, '2020:03:07', 51.24);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (18, 'Shale', TRUE, 77.351080, 2.023432, '2019:12:12', 18.24);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (20, 'Amethyst', TRUE, 68.459761, -106.923824, '2014:09:28', 141.10);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (30, 'Diamond', TRUE, 18.199803, 24.294815, '2018:11:01', 16.70);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (11, 'Gold', TRUE, 65.134274, -17.325840, '2005:06:23', 119.27);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (27, 'Amethyst', TRUE, 22.945399, -30.740164, '2016:08:21', 122.73);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (17, 'Diamond', TRUE, -86.726511, -69.721857, '2000:04:26', 138.20);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (12, 'Shale', TRUE, -43.971872, 166.674777, '2020:10:14', 31.87);
Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (4, 'Lithite', TRUE, 28.032300, -174.707915, '2002:10:21', 131.70);

/*
Member data randomly generated as well
*/
Insert Into Member Values (74, 3);
Insert Into Member Values (1, 1);
Insert Into Member Values (98, 4);
Insert Into Member Values (49, 5);
Insert Into Member Values (62, 5);
Insert Into Member Values (55, 5);
Insert Into Member Values (24, 4);
Insert Into Member Values (54, 4);
Insert Into Member Values (42, 1);
Insert Into Member Values (93, 5);
Insert Into Member Values (75, 2);
Insert Into Member Values (12, 2);
Insert Into Member Values (23, 4);
Insert Into Member Values (24, 1);
Insert Into Member Values (24, 2);
Insert Into Member Values (22, 4);
Insert Into Member Values (40, 2);
Insert Into Member Values (98, 6);
Insert Into Member Values (90, 3);
Insert Into Member Values (56, 3);
Insert Into Member Values (22, 5);
Insert Into Member Values (12, 1);
Insert Into Member Values (29, 3);
Insert Into Member Values (34, 5);
Insert Into Member Values (46, 4);
Insert Into Member Values (58, 2);
Insert Into Member Values (56, 6);
Insert Into Member Values (10, 5);
Insert Into Member Values (83, 2);
Insert Into Member Values (96, 1);
Insert Into Member Values (84, 4);
Insert Into Member Values (59, 6);
Insert Into Member Values (64, 3);
Insert Into Member Values (5, 5);
Insert Into Member Values (54, 6);
Insert Into Member Values (51, 6);
Insert Into Member Values (87, 6);
Insert Into Member Values (19, 4);
Insert Into Member Values (94, 3);
Insert Into Member Values (78, 3);
Insert Into Member Values (7, 3);
Insert Into Member Values (56, 3);
Insert Into Member Values (25, 1);
Insert Into Member Values (16, 6);
Insert Into Member Values (70, 1);
Insert Into Member Values (77, 5);
Insert Into Member Values (66, 1);
Insert Into Member Values (41, 3);
Insert Into Member Values (97, 3);
Insert Into Member Values (17, 3);
Insert Into Member Values (67, 3);
Insert Into Member Values (7, 2);
Insert Into Member Values (50, 6);
Insert Into Member Values (29, 1);
Insert Into Member Values (15, 5);
Insert Into Member Values (24, 1);
Insert Into Member Values (92, 3);
Insert Into Member Values (66, 3);
Insert Into Member Values (20, 2);
Insert Into Member Values (95, 5);
Insert Into Member Values (70, 3);
Insert Into Member Values (3, 6);
Insert Into Member Values (7, 1);
Insert Into Member Values (23, 6);
Insert Into Member Values (87, 1);
Insert Into Member Values (42, 6);
Insert Into Member Values (33, 6);
Insert Into Member Values (58, 5);
Insert Into Member Values (46, 4);
Insert Into Member Values (15, 2);
Insert Into Member Values (16, 1);
Insert Into Member Values (85, 5);
Insert Into Member Values (20, 6);
Insert Into Member Values (17, 5);
Insert Into Member Values (95, 2);
Insert Into Member Values (92, 5);
Insert Into Member Values (53, 6);
Insert Into Member Values (44, 5);
Insert Into Member Values (27, 6);
Insert Into Member Values (18, 2);
Insert Into Member Values (92, 5);
Insert Into Member Values (54, 5);
Insert Into Member Values (54, 1);
Insert Into Member Values (35, 2);
Insert Into Member Values (1, 6);
Insert Into Member Values (73, 3);
Insert Into Member Values (20, 1);
Insert Into Member Values (24, 4);
Insert Into Member Values (28, 3);
Insert Into Member Values (25, 1);
Insert Into Member Values (82, 6);
Insert Into Member Values (37, 1);
Insert Into Member Values (68, 3);
Insert Into Member Values (99, 6);
Insert Into Member Values (78, 2);
Insert Into Member Values (64, 3);
Insert Into Member Values (6, 2);
Insert Into Member Values (22, 3);
Insert Into Member Values (19, 2);
Insert Into Member Values (34, 2);

/*
Project member values
*/
Insert Into ProjMember Values (24, 3, '2017:12:20');
Insert Into ProjMember Values (17, 5, '2003:05:11');
Insert Into ProjMember Values (11, 6, '2016:02:02');
Insert Into ProjMember Values (21, 1, '2020:01:13');
Insert Into ProjMember Values (30, 2, '2000:03:03');
Insert Into ProjMember Values (14, 4, '2008:03:10');
Insert Into ProjMember Values (9, 2, '2007:09:01');
Insert Into ProjMember Values (7, 2, '2007:10:27');
Insert Into ProjMember Values (4, 4, '2013:02:13');
Insert Into ProjMember Values (13, 1, '2004:08:16');
Insert Into ProjMember Values (11, 5, '2005:07:10');
Insert Into ProjMember Values (4, 6, '2014:05:12');
Insert Into ProjMember Values (8, 1, '2013:07:17');
Insert Into ProjMember Values (20, 2, '2011:02:15');
Insert Into ProjMember Values (7, 6, '2000:02:28');
Insert Into ProjMember Values (30, 6, '2017:05:06');
Insert Into ProjMember Values (26, 5, '2014:03:10');
Insert Into ProjMember Values (28, 3, '2018:11:12');
Insert Into ProjMember Values (1, 3, '2021:03:13');
Insert Into ProjMember Values (15, 1, '2007:04:28');
Insert Into ProjMember Values (9, 1, '2004:07:25');
Insert Into ProjMember Values (12, 2, '2015:06:19');
Insert Into ProjMember Values (7, 5, '2021:04:01');
Insert Into ProjMember Values (23, 3, '2020:08:27');
Insert Into ProjMember Values (12, 2, '2011:12:07');
Insert Into ProjMember Values (4, 2, '2003:01:27');
Insert Into ProjMember Values (29, 1, '2004:04:25');
Insert Into ProjMember Values (29, 1, '2011:05:07');
Insert Into ProjMember Values (14, 3, '2010:07:22');
Insert Into ProjMember Values (21, 6, '2001:05:16');

/*
Market should only really have a few rows
*/
Insert Into Market Values ('normal');
Insert Into Market Values ('auction');

/*
Sales
*/

Insert Into Sale Values (67, 'auction', 60.59);
Insert Into Sale Values (96, 'auction', 192.61);
Insert Into Sale Values (69, 'auction', 98.98);
Insert Into Sale Values (88, 'normal', 150.09);
Insert Into Sale Values (34, 'auction', 55.39);
Insert Into Sale Values (6, 'auction', 136.65);
Insert Into Sale Values (30, 'normal', 36.44);
Insert Into Sale Values (53, 'auction', 122.90);
Insert Into Sale Values (13, 'auction', 148.85);
Insert Into Sale Values (3, 'auction', 73.08);
Insert Into Sale Values (53, 'normal', 56.54);
Insert Into Sale Values (92, 'normal', 79.36);
Insert Into Sale Values (59, 'auction', 70.49);
Insert Into Sale Values (23, 'normal', 74.22);
Insert Into Sale Values (77, 'auction', 6.50);
Insert Into Sale Values (5, 'auction', 157.76);
Insert Into Sale Values (4, 'auction', 147.76);
Insert Into Sale Values (58, 'normal', 82.53);
Insert Into Sale Values (81, 'normal', 196.47);
Insert Into Sale Values (15, 'normal', 158.12);
Insert Into Sale Values (54, 'normal', 38.25);
Insert Into Sale Values (57, 'normal', 104.99);
Insert Into Sale Values (37, 'auction', 96.15);
Insert Into Sale Values (29, 'normal', 167.16);
Insert Into Sale Values (16, 'auction', 163.55);
Insert Into Sale Values (22, 'normal', 148.18);
Insert Into Sale Values (38, 'auction', 21.01);
Insert Into Sale Values (64, 'auction', 143.13);
Insert Into Sale Values (50, 'normal', 84.33);
Insert Into Sale Values (73, 'normal', 116.15);
