/*
 Navicat Premium Data Transfer

 Source Server         : dev-192.168.110.220
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 192.168.110.220:3306
 Source Schema         : aosica-base

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 14/11/2019 09:47:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典类型',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典名编码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典',
  `value` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典值',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (324041514078044300, 'monitoring_items', 'guangzhaodu', '光照度', '1', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044301, 'monitoring_items', 'co', 'CO', '2', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044302, 'monitoring_items', 'rssi', '信号强度', '3', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044303, 'monitoring_items', 'PM10', 'PM10', '4', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044304, 'monitoring_items', 'PM2.5', 'PM2.5', '5', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044305, 'monitoring_items', 'soilph', '土壤PH', '6', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044306, 'monitoring_items', 'barometric', '大气压力', '7', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044307, 'monitoring_items', 'noise', '噪声', '8', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044308, 'monitoring_items', 'windspeed', '风速', '9', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044309, 'monitoring_items', 'so2', 'SO2', '10', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044310, 'monitoring_items', 'temperature', '温度', '11', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044311, 'monitoring_items', 'humidity', '湿度', '12', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044312, 'monitoring_items', 'soilTem', '土壤温度', '13', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044313, 'monitoring_items', 'soilHum', '土壤湿度', '14', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044314, 'monitoring_items', 'rainfal', '雨量', '15', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044315, 'monitoring_items', 'wind_direction', '风向', '16', '2019-08-21 14:54:57');
INSERT INTO `sys_dict` VALUES (324041514078044401, 'equipment_type', NULL, '火灾自动报警系统', '1', '2019-08-21 14:41:01');
INSERT INTO `sys_dict` VALUES (324041514078044402, 'equipment_type', NULL, '独立烟感云传输系统', '2', '2019-08-21 14:41:01');
INSERT INTO `sys_dict` VALUES (324041514078044403, 'equipment_type', NULL, '粉尘监测云传输系统', '3', '2019-08-21 14:41:01');
INSERT INTO `sys_dict` VALUES (324041514078044404, 'equipment_type', NULL, '可燃气体云传输系统', '4', '2019-08-21 14:41:01');
INSERT INTO `sys_dict` VALUES (324041514078044405, 'equipment_type', NULL, '电气火灾监控系统', '5', '2019-08-21 14:41:01');
INSERT INTO `sys_dict` VALUES (324041514078044406, 'equipment_type', NULL, '室内水压监控系统', '6', '2019-08-21 14:41:01');
INSERT INTO `sys_dict` VALUES (324041514078044407, 'equipment_type', NULL, '室外水压监控系统', '7', '2019-08-21 14:41:01');
INSERT INTO `sys_dict` VALUES (324041514078044408, 'equipment_type', NULL, '视频监控系统', '8', '2019-08-21 14:41:01');
INSERT INTO `sys_dict` VALUES (324041514078044409, 'equipment_type', NULL, '应急监控云传输系统', '9', '2019-08-21 14:41:01');
INSERT INTO `sys_dict` VALUES (324041514078044410, 'role_type', NULL, '系统管理员', '1', '2019-08-23 11:08:51');
INSERT INTO `sys_dict` VALUES (324041514078044411, 'role_type', NULL, '厂家人员', '2', '2019-08-23 11:09:51');
INSERT INTO `sys_dict` VALUES (324041514078044412, 'role_type', NULL, '运维人员', '3', '2019-08-23 11:10:17');
INSERT INTO `sys_dict` VALUES (324041514078044413, 'role_type', NULL, '普通用户', '4', '2019-08-23 11:10:47');

-- ----------------------------
-- Table structure for t_base_area
-- ----------------------------
DROP TABLE IF EXISTS `t_base_area`;
CREATE TABLE `t_base_area`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `par_code` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `street` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `org_code_area_name_index`(`name`) USING BTREE,
  INDEX `org_code_level_index`(`type`) USING BTREE,
  INDEX `org_code_parentCode_index`(`par_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '省市区-区域表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_area
-- ----------------------------
INSERT INTO `t_base_area` VALUES (4, '北京市', '北京', '100', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012972247977984, '北京市', '北京', '100001', '100', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012972247977985, '东城区', '东城区', '100001001', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012972495441921, '西城区', '西城区', '100001002', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012972675796993, '朝阳区', '朝阳区', '100001003', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012972847763457, '丰台区', '丰台区', '100001004', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012973028118529, '石景山区', '石景山区', '100001005', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012973262999553, '海淀区', '海淀区', '100001006', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012973447548929, '门头沟区', '门头沟区', '100001007', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012973619515393, '房山区', '房山区', '100001008', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012973804064769, '通州区', '通州区', '100001009', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012973980225537, '顺义区', '顺义区', '100001010', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012974173163521, '昌平区', '昌平区', '100001011', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012974345129985, '大兴区', '大兴区', '100001012', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012974504513537, '怀柔区', '怀柔区', '100001013', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012974672285697, '密云区', '密云区', '100001014', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012974861029377, '延庆区', '延庆区', '100001015', '100001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012975028801536, '天津市', '天津', '110', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012975163019264, '天津市', '天津市', '110001', '110', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012975163019265, '和平区', '和平区', '110001001', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012975431454721, '河东区', '河东区', '110001002', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012975628587009, '河西区', '河西区', '110001003', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012975804747777, '南开区', '南开区', '110001004', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012975980908545, '河北区', '河北区', '110001005', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012976140292097, '红桥区', '红桥区', '110001006', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012976308064257, '东丽区', '东丽区', '110001007', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012976488419329, '西青区', '西青区', '110001008', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012976639414273, '津南区', '津南区', '110001009', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012976802992129, '北辰区', '北辰区', '110001010', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012976962375681, '武清区', '武清区', '110001011', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012977138536449, '宝坻区', '宝坻区', '110001012', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012977293725697, '宁河区', '宁河区', '110001013', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012977453109249, '静海区', '静海区', '110001014', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012977608298497, '滨海新区', '滨海新区', '110001015', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012977771876353, '蓟州区', '蓟州区', '110001016', '110001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012977935454208, '河北省', '河北', '120', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012978048700416, '石家庄市', '石家庄市', '120001', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012978048700417, '长安区', '长安区', '120001001', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012978296164353, '裕华区', '裕华区', '120001002', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012978447159297, '桥西区', '桥西区', '120001003', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012978598154241, '新华区', '新华区', '120001004', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012978753343489, '藁城区', '藁城区', '120001005', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012978916921345, '鹿泉区', '鹿泉区', '120001006', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012979072110593, '栾城区', '栾城区', '120001007', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012979231494145, '井陉矿区', '井陉矿区', '120001008', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012979378294785, '井陉县', '井陉县', '120001009', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012979541872641, '正定县', '正定县', '120001010', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012979697061889, '栾城县', '栾城县', '120001011', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012979856445441, '行唐县', '行唐县', '120001012', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012980007440385, '灵寿县', '灵寿县', '120001013', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012980162629633, '高邑县', '高邑县', '120001014', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012980330401793, '深泽县', '深泽县', '120001015', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012980493979649, '赞皇县', '赞皇县', '120001016', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012980661751809, '无极县', '无极县', '120001017', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012980816941057, '平山县', '平山县', '120001018', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012980976324609, '元氏县', '元氏县', '120001019', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012981127319553, '赵县', '赵县', '120001020', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012981282508801, '辛集市', '辛集市', '120001021', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012981441892353, '晋州市', '晋州市', '120001022', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012981597081601, '新乐市', '新乐市', '120001023', '120001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012981760659456, '唐山市', '唐山市', '120002', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012981760659457, '路南区', '路南区', '120002001', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012981991346177, '路北区', '路北区', '120002002', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012982154924033, '古冶区', '古冶区', '120002003', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012982322696193, '开平区', '开平区', '120002004', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012982486274049, '丰润区', '丰润区', '120002005', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012982645657601, '丰南区', '丰南区', '120002006', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012982805041153, '曹妃甸区', '曹妃甸区', '120002007', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012982956036097, '遵化市', '遵化市', '120002008', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012983111225345, '迁安市', '迁安市', '120002009', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012983274803201, '滦县', '滦县', '120002010', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012983438381057, '滦南县', '滦南县', '120002011', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012983589376001, '乐亭县', '乐亭县', '120002012', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012983731982337, '迁西县', '迁西县', '120002013', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012983887171585, '玉田县', '玉田县', '120002014', '120002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012984050749440, '秦皇岛市', '秦皇岛市', '120003', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012984050749441, '海港区', '海港区', '120003001', '120003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012984294019073, '山海关区', '山海关区', '120003002', '120003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012984453402625, '北戴河区', '北戴河区', '120003003', '120003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012984600203265, '抚宁区', '抚宁区', '120003004', '120003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012984759586817, '昌黎县', '昌黎县', '120003005', '120003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012984918970369, '卢龙县', '卢龙县', '120003006', '120003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012985082548225, '青龙满族自治县', '青龙满族自治县', '120003007', '120003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012985250320384, '邯郸市', '邯郸市', '120004', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012985250320385, '邯山区', '邯山区', '120004001', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012985481007105, '丛台区', '丛台区', '120004002', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012985636196353, '复兴区', '复兴区', '120004003', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012985787191297, '峰峰矿区', '峰峰矿区', '120004004', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012985946574849, '肥乡区', '肥乡区', '120004005', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012986118541313, '永年区', '永年区', '120004006', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012986273730561, '成安县', '成安县', '120004007', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012986445697025, '大名县', '大名县', '120004008', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012986609274881, '涉县', '涉县', '120004009', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012986751881217, '磁县', '磁县', '120004010', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012986898681857, '临漳县', '临漳县', '120004011', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012987053871105, '邱县', '邱县', '120004012', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012987209060353, '鸡泽县', '鸡泽县', '120004013', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012987368443905, '广平县', '广平县', '120004014', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012987519438849, '馆陶县', '馆陶县', '120004015', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012987674628097, '魏县', '魏县', '120004016', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012987829817345, '曲周县', '曲周县', '120004017', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012987985006593, '武安市', '武安市', '120004018', '120004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012988144390144, '邢台市', '邢台市', '120005', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012988144390145, '桥东区', '桥东区', '120005001', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012988366688257, '桥西区', '桥西区', '120005002', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012988513488897, '邢台县', '邢台县', '120005003', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012988664483841, '临城县', '临城县', '120005004', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012988815478785, '内丘县', '内丘县', '120005005', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012988966473729, '柏乡县', '柏乡县', '120005006', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012989121662977, '隆尧县', '隆尧县', '120005007', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012989272657921, '任县', '任县', '120005008', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012989427847169, '南和县', '南和县', '120005009', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012989591425025, '宁晋县', '宁晋县', '120005010', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012989750808577, '巨鹿县', '巨鹿县', '120005011', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012989901803521, '新河县', '新河县', '120005012', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012990056992769, '广宗县', '广宗县', '120005013', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012990212182017, '平乡县', '平乡县', '120005014', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012990367371265, '威县', '威县', '120005015', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012990526754817, '清河县', '清河县', '120005016', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012990677749761, '临西县', '临西县', '120005017', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012990828744705, '南宫市', '南宫市', '120005018', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012990988128257, '沙河市', '沙河市', '120005019', '120005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012991134928896, '保定市', '保定市', '120006', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012991134928897, '竞秀区', '竞秀区', '120006001', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012991374004225, '莲池区', '莲池区', '120006002', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012991520804865, '满城区', '满城区', '120006003', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012991675994113, '清苑区', '清苑区', '120006004', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012991835377665, '徐水区', '徐水区', '120006005', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012991990566913, '涞水县', '涞水县', '120006006', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012992145756161, '阜平县', '阜平县', '120006007', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012992296751105, '定兴县', '定兴县', '120006008', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012992447746049, '唐县', '唐县', '120006009', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012992598740993, '高阳县', '高阳县', '120006010', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012992770707457, '容城县', '容城县', '120006011', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012992917508097, '涞源县', '涞源县', '120006012', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012993068503041, '望都县', '望都县', '120006013', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012993219497985, '安新县', '安新县', '120006014', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012993366298625, '易县', '易县', '120006015', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012993525682177, '曲阳县', '曲阳县', '120006016', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012993676677121, '蠡县', '蠡县', '120006017', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012993823477761, '顺平县', '顺平县', '120006018', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012993982861313, '博野县', '博野县', '120006019', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012994129661953, '雄县', '雄县', '120006020', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012994276462593, '涿州市', '涿州市', '120006021', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012994427457537, '定州市', '定州市', '120006022', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012994578452481, '安国市', '安国市', '120006023', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012994729447425, '高碑店市', '高碑店市', '120006024', '120006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012994893025280, '张家口市', '张家口市', '120007', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012994893025281, '桥东区', '桥东区', '120007001', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012995115323393, '桥西区', '桥西区', '120007002', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012995266318337, '宣化区', '宣化区', '120007003', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012995429896193, '下花园区', '下花园区', '120007004', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012995580891137, '万全区', '万全区', '120007005', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012995740274689, '崇礼区', '崇礼区', '120007006', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012995891269633, '张北县', '张北县', '120007007', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012996046458881, '康保县', '康保县', '120007008', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012996205842433, '沽源县', '沽源县', '120007009', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012996352643073, '尚义县', '尚义县', '120007010', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012996507832321, '蔚县', '蔚县', '120007011', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012996667215873, '阳原县', '阳原县', '120007012', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012996814016513, '怀安县', '怀安县', '120007013', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012996969205761, '怀来县', '怀来县', '120007014', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012997120200705, '涿鹿县', '涿鹿县', '120007015', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012997279584257, '赤城县', '赤城县', '120007016', '120007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012997426384896, '承德市', '承德市', '120008', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012997426384897, '双桥区', '双桥区', '120008001', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012997669654529, '双滦区', '双滦区', '120008002', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012997824843777, '鹰手营子矿区', '鹰手营子矿区', '120008003', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012997975838721, '承德县', '承德县', '120008004', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012998118445057, '兴隆县', '兴隆县', '120008005', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012998273634305, '平泉县', '平泉县', '120008006', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012998428823553, '滦平县', '滦平县', '120008007', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012998579818497, '隆化县', '隆化县', '120008008', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012998739202049, '丰宁满族自治县', '丰宁满族自治县', '120008009', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012998894391297, '宽城满族自治县', '宽城满族自治县', '120008010', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012999045386241, '围场满族蒙古族自治县', '围场满族蒙古族自治县', '120008011', '120008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012999196381184, '沧州市', '沧州市', '120009', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012999196381185, '新华区', '新华区', '120009001', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012999427067905, '运河区', '运河区', '120009002', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012999590645761, '沧县', '沧县', '120009003', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012999745835009, '青县', '青县', '120009004', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1012999892635649, '东光县', '东光县', '120009005', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013000047824897, '海兴县', '海兴县', '120009006', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013000203014145, '盐山县', '盐山县', '120009007', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013000354009089, '肃宁县', '肃宁县', '120009008', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013000500809729, '南皮县', '南皮县', '120009009', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013000676970497, '吴桥县', '吴桥县', '120009010', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013000836354049, '献县', '献县', '120009011', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013000987348993, '孟村回族自治县', '孟村回族自治县', '120009012', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013001134149633, '泊头市', '泊头市', '120009013', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013001293533185, '任丘市', '任丘市', '120009014', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013001448722433, '黄骅市', '黄骅市', '120009015', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013001616494593, '河间市', '河间市', '120009016', '120009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013001775878144, '廊坊市', '廊坊市', '120010', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013001775878145, '广阳区', '广阳区', '120010001', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013002002370561, '安次区', '安次区', '120010002', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013002161754113, '固安县', '固安县', '120010003', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013002321137665, '永清县', '永清县', '120010004', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013002472132609, '香河县', '香河县', '120010005', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013002631516161, '大城县', '大城县', '120010006', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013002782511105, '文安县', '文安县', '120010007', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013002946088961, '大厂回族自治县', '大厂回族自治县', '120010008', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013003105472513, '霸州市', '霸州市', '120010009', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013003256467457, '三河市', '三河市', '120010010', '120010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013003403268096, '衡水市', '衡水市', '120011', '120', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013003403268097, '桃城区', '桃城区', '120011001', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013003633954817, '冀州区', '冀州区', '120011002', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013003797532673, '枣强县', '枣强县', '120011003', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013003961110529, '武邑县', '武邑县', '120011004', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013004120494081, '武强县', '武强县', '120011005', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013004275683329, '饶阳县', '饶阳县', '120011006', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013004430872577, '安平县', '安平县', '120011007', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013004581867521, '故城县', '故城县', '120011008', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013004732862465, '景县', '景县', '120011009', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013004892246017, '阜城县', '阜城县', '120011010', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013005043240961, '深州市', '深州市', '120011011', '120011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013005202624512, '山西省', '山西', '130', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013005324259328, '太原市', '太原市', '130001', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013005324259329, '小店区', '小店区', '130001001', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013005550751745, '迎泽区', '迎泽区', '130001002', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013005714329601, '杏花岭区', '杏花岭区', '130001003', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013005869518849, '尖草坪区', '尖草坪区', '130001004', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013006028902401, '万柏林区', '万柏林区', '130001005', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013006171508737, '晋源区', '晋源区', '130001006', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013006335086593, '清徐县', '清徐县', '130001007', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013006477692929, '阳曲县', '阳曲县', '130001008', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013006632882177, '娄烦县', '娄烦县', '130001009', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013006796460033, '古交市', '古交市', '130001010', '130001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013006951649280, '大同市', '大同市', '130002', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013006951649281, '城区', '城区', '130002001', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013007186530305, '矿区', '矿区', '130002002', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013007341719553, '南郊区', '南郊区', '130002003', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013007501103105, '新荣区', '新荣区', '130002004', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013007656292353, '阳高县', '阳高县', '130002005', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013007815675905, '天镇县', '天镇县', '130002006', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013007970865153, '广灵县', '广灵县', '130002007', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013008121860097, '灵丘县', '灵丘县', '130002008', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013008268660737, '浑源县', '浑源县', '130002009', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013008419655681, '左云县', '左云县', '130002010', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013008574844929, '大同县', '大同县', '130002011', '130002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013008730034176, '阳泉市', '阳泉市', '130003', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013008730034177, '城区', '城区', '130003001', '130003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013008956526593, '矿区', '矿区', '130003002', '130003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013009111715841, '郊区', '郊区', '130003003', '130003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013009271099393, '平定县', '平定县', '130003004', '130003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013009417900033, '盂县', '盂县', '130003005', '130003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013009568894976, '长治市', '长治市', '130004', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013009568894977, '城区', '城区', '130004001', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013009799581697, '郊区', '郊区', '130004002', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013009937993729, '长治县', '长治县', '130004003', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013010088988673, '襄垣县', '襄垣县', '130004004', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013010248372225, '屯留县', '屯留县', '130004005', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013010399367169, '平顺县', '平顺县', '130004006', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013010562945025, '黎城县', '黎城县', '130004007', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013010713939969, '壶关县', '壶关县', '130004008', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013010856546305, '长子县', '长子县', '130004009', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013011003346945, '武乡县', '武乡县', '130004010', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013011154341889, '沁县', '沁县', '130004011', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013011322114049, '沁源县', '沁源县', '130004012', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013011481497601, '潞城市', '潞城市', '130004013', '130004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013011640881152, '晋城市', '晋城市', '130005', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013011640881153, '城区', '城区', '130005001', '130005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013011858984961, '沁水县', '沁水县', '130005002', '130005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013012014174209, '阳城县', '阳城县', '130005003', '130005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013012181946369, '陵川县', '陵川县', '130005004', '130005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013012341329921, '泽州县', '泽州县', '130005005', '130005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013012492324865, '高平市', '高平市', '130005006', '130005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013012651708416, '朔州市', '朔州市', '130006', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013012651708417, '朔城区', '朔城区', '130006001', '130006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013012874006529, '平鲁区', '平鲁区', '130006002', '130006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013013020807169, '山阴县', '山阴县', '130006003', '130006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013013180190721, '应县', '应县', '130006004', '130006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013013322797057, '右玉县', '右玉县', '130006005', '130006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013013469597697, '怀仁县', '怀仁县', '130006006', '130006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013013612204032, '忻州市', '忻州市', '130007', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013013612204033, '忻府区', '忻府区', '130007001', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013013855473665, '原平市', '原平市', '130007002', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013014006468609, '定襄县', '定襄县', '130007003', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013014161657857, '五台县', '五台县', '130007004', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013014300069889, '代县', '代县', '130007005', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013014455259137, '繁峙县', '繁峙县', '130007006', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013014606254081, '宁武县', '宁武县', '130007007', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013014757249025, '静乐县', '静乐县', '130007008', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013014912438273, '神池县', '神池县', '130007009', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013015059238913, '五寨县', '五寨县', '130007010', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013015210233857, '岢岚县', '岢岚县', '130007011', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013015357034497, '河曲县', '河曲县', '130007012', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013015508029441, '保德县', '保德县', '130007013', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013015663218689, '偏关县', '偏关县', '130007014', '130007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013015810019328, '吕梁市', '吕梁市', '130008', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013015810019329, '离石区', '离石区', '130008001', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013016036511745, '孝义市', '孝义市', '130008002', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013016183312385, '汾阳市', '汾阳市', '130008003', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013016342695937, '文水县', '文水县', '130008004', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013016493690881, '交城县', '交城县', '130008005', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013016653074433, '兴县', '兴县', '130008006', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013016804069377, '临县', '临县', '130008007', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013016963452929, '柳林县', '柳林县', '130008008', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013017114447873, '石楼县', '石楼县', '130008009', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013017261248513, '岚县', '岚县', '130008010', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013017408049153, '方山县', '方山县', '130008011', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013017550655489, '中阳县', '中阳县', '130008012', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013017697456129, '交口县', '交口县', '130008013', '130008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013017835868160, '晋中市', '晋中市', '130009', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013017835868161, '榆次区', '榆次区', '130009001', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013018049777665, '介休市', '介休市', '130009002', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013018204966913, '榆社县', '榆社县', '130009003', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013018360156161, '左权县', '左权县', '130009004', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013018523734017, '和顺县', '和顺县', '130009005', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013018670534657, '昔阳县', '昔阳县', '130009006', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013018817335297, '寿阳县', '寿阳县', '130009007', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013018980913153, '太谷县', '太谷县', '130009008', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013019127713793, '祁县', '祁县', '130009009', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013019282903041, '平遥县', '平遥县', '130009010', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013019438092289, '灵石县', '灵石县', '130009011', '130009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013019589087232, '临汾市', '临汾市', '130010', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013019589087233, '尧都区', '尧都区', '130010001', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013019819773953, '侯马市', '侯马市', '130010002', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013019966574593, '霍州市', '霍州市', '130010003', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013020125958145, '曲沃县', '曲沃县', '130010004', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013020281147393, '翼城县', '翼城县', '130010005', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013020432142337, '襄汾县', '襄汾县', '130010006', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013020587331585, '洪洞县', '洪洞县', '130010007', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013020734132225, '古县', '古县', '130010008', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013020885127169, '安泽县', '安泽县', '130010009', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013021044510721, '浮山县', '浮山县', '130010010', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013021191311361, '吉县', '吉县', '130010011', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013021338112001, '乡宁县', '乡宁县', '130010012', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013021489106945, '蒲县', '蒲县', '130010013', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013021640101889, '大宁县', '大宁县', '130010014', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013021795291137, '永和县', '永和县', '130010015', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013021954674689, '隰县', '隰县', '130010016', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013022105669633, '汾西县', '汾西县', '130010017', '130010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013022252470272, '运城市', '运城市', '130011', '130', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013022252470273, '盐湖区', '盐湖区', '130011001', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013022470574081, '永济市', '永济市', '130011002', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013022621569025, '河津市', '河津市', '130011003', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013022776758273, '芮城县', '芮城县', '130011004', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013022927753217, '临猗县', '临猗县', '130011005', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013023074553857, '万荣县', '万荣县', '130011006', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013023221354497, '新绛县', '新绛县', '130011007', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013023363960833, '稷山县', '稷山县', '130011008', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013023506567169, '闻喜县', '闻喜县', '130011009', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013023661756416, '夏县', '夏县', '130011010', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013023808557057, '绛县', '绛县', '130011011', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013023959552001, '平陆县', '平陆县', '130011012', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013024106352641, '垣曲县', '垣曲县', '130011013', '130011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013024261541888, '内蒙古', '内蒙古', '140', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013024374788096, '呼和浩特市', '呼和浩特市', '140001', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013024374788097, '新城区', '新城区', '140001001', '140001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013024597086209, '回民区', '回民区', '140001002', '140001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013024743886849, '玉泉区', '玉泉区', '140001003', '140001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013024894881793, '赛罕区', '赛罕区', '140001004', '140001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013025045876737, '土默特左旗', '土默特左旗', '140001005', '140001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013025192677377, '托克托县', '托克托县', '140001006', '140001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013025335283713, '和林格尔县', '和林格尔县', '140001007', '140001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013025486278657, '清水河县', '清水河县', '140001008', '140001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013025633079297, '武川县', '武川县', '140001009', '140001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013025779879936, '包头市', '包头市', '140002', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013025779879937, '东河区', '东河区', '140002001', '140002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013025997983745, '昆都仑区', '昆都仑区', '140002002', '140002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013026153172993, '青山区', '青山区', '140002003', '140002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013026291585025, '石拐区', '石拐区', '140002004', '140002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013026446774273, '白云鄂博矿区', '白云鄂博矿区', '140002005', '140002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013026597769217, '九原区', '九原区', '140002006', '140002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013026736181249, '土默特右旗', '土默特右旗', '140002007', '140002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013026874593281, '固阳县', '固阳县', '140002008', '140002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013027025588225, '达尔罕茂明安联合旗', '达尔罕茂明安联合旗', '140002009', '140002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013027172388864, '乌海市', '乌海市', '140003', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013027172388865, '海勃湾区', '海勃湾区', '140003001', '140003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013027398881281, '海南区', '海南区', '140003002', '140003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013027545681921, '乌达区', '乌达区', '140003003', '140003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013027692482560, '赤峰市', '赤峰市', '140004', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013027692482561, '红山区', '红山区', '140004001', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013027910586369, '元宝山区', '元宝山区', '140004002', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013028069969921, '松山区', '松山区', '140004003', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013028216770561, '阿鲁科尔沁旗', '阿鲁科尔沁旗', '140004004', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013028355182593, '巴林左旗', '巴林左旗', '140004005', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013028501983233, '巴林右旗', '巴林右旗', '140004006', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013028640395265, '林西县', '林西县', '140004007', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013028791390209, '克什克腾旗', '克什克腾旗', '140004008', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013028942385153, '翁牛特旗', '翁牛特旗', '140004009', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013029093380097, '喀喇沁旗', '喀喇沁旗', '140004010', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013029231792129, '宁城县', '宁城县', '140004011', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013029378592769, '敖汉旗', '敖汉旗', '140004012', '140004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013029517004800, '呼伦贝尔市', '呼伦贝尔市', '140005', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013029517004801, '海拉尔区', '海拉尔区', '140005001', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013029743497217, '扎赉诺尔区', '扎赉诺尔区', '140005002', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013029890297857, '满洲里市', '满洲里市', '140005003', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013030037098497, '扎兰屯市', '扎兰屯市', '140005004', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013030188093441, '牙克石市', '牙克石市', '140005005', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013030330699777, '根河市', '根河市', '140005006', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013030477500417, '额尔古纳市', '额尔古纳市', '140005007', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013030624301057, '阿荣旗', '阿荣旗', '140005008', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013030771101697, '莫力达瓦达斡尔族自治旗', '莫力达瓦达斡尔族自治旗', '140005009', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013030909513729, '鄂伦春自治旗', '鄂伦春自治旗', '140005010', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013031056314369, '鄂温克族自治旗', '鄂温克族自治旗', '140005011', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013031198920705, '新巴尔虎右旗', '新巴尔虎右旗', '140005012', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013031337332737, '新巴尔虎左旗', '新巴尔虎左旗', '140005013', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013031484133377, '陈巴尔虎旗', '陈巴尔虎旗', '140005014', '140005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013031630934016, '兴安盟', '兴安盟', '140006', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013031630934017, '乌兰浩特市', '乌兰浩特市', '140006001', '140006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013031853232129, '阿尔山市', '阿尔山市', '140006002', '140006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013031991644161, '科尔沁右翼前旗', '科尔沁右翼前旗', '140006003', '140006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013032134250497, '科尔沁右翼中旗', '科尔沁右翼中旗', '140006004', '140006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013032281051137, '扎赉特旗', '扎赉特旗', '140006005', '140006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013032432046081, '突泉县', '突泉县', '140006006', '140006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013032591429632, '通辽市', '通辽市', '140007', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013032591429633, '科尔沁区', '科尔沁区', '140007001', '140007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013032813727745, '霍林郭勒市', '霍林郭勒市', '140007002', '140007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013032952139777, '科尔沁左翼中旗', '科尔沁左翼中旗', '140007003', '140007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013033098940417, '科尔沁左翼后旗', '科尔沁左翼后旗', '140007004', '140007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013033237352449, '开鲁县', '开鲁县', '140007005', '140007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013033392541697, '库伦旗', '库伦旗', '140007006', '140007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013033530953729, '奈曼旗', '奈曼旗', '140007007', '140007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013033681948673, '扎鲁特旗', '扎鲁特旗', '140007008', '140007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013033828749312, '锡林郭勒盟', '锡林郭勒盟', '140008', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013033828749313, '二连浩特市', '二连浩特市', '140008001', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013034046853121, '锡林浩特市', '锡林浩特市', '140008002', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013034189459457, '阿巴嘎旗', '阿巴嘎旗', '140008003', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013034344648705, '苏尼特左旗', '苏尼特左旗', '140008004', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013034491449345, '苏尼特右旗', '苏尼特右旗', '140008005', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013034638249985, '东乌珠穆沁旗', '东乌珠穆沁旗', '140008006', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013034780856321, '西乌珠穆沁旗', '西乌珠穆沁旗', '140008007', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013034940239873, '太仆寺旗', '太仆寺旗', '140008008', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013035095429121, '镶黄旗', '镶黄旗', '140008009', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013035250618369, '正镶白旗', '正镶白旗', '140008010', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013035397419009, '正蓝旗', '正蓝旗', '140008011', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013035552608257, '多伦县', '多伦县', '140008012', '140008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013035695214592, '乌兰察布市', '乌兰察布市', '140009', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013035695214593, '集宁区', '集宁区', '140009001', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013035921707009, '丰镇市', '丰镇市', '140009002', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013036064313345, '卓资县', '卓资县', '140009003', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013036236279809, '化德县', '化德县', '140009004', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013036395663361, '商都县', '商都县', '140009005', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013036542464001, '兴和县', '兴和县', '140009006', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013036693458945, '凉城县', '凉城县', '140009007', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013036844453889, '察哈尔右翼前旗', '察哈尔右翼前旗', '140009008', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013036991254529, '察哈尔右翼中旗', '察哈尔右翼中旗', '140009009', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013037138055169, '察哈尔右翼后旗', '察哈尔右翼后旗', '140009010', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013037280661505, '四子王旗', '四子王旗', '140009011', '140009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013037423267840, '鄂尔多斯市', '鄂尔多斯市', '140010', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013037423267841, '东胜区', '东胜区', '140010001', '140010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013037641371649, '康巴什区', '康巴什区', '140010002', '140010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013037817532417, '达拉特旗', '达拉特旗', '140010003', '140010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013037968527361, '准格尔旗', '准格尔旗', '140010004', '140010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013038123716609, '鄂托克前旗', '鄂托克前旗', '140010005', '140010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013038266322945, '鄂托克旗', '鄂托克旗', '140010006', '140010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013038417317889, '杭锦旗', '杭锦旗', '140010007', '140010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013038572507137, '伊金霍洛旗', '伊金霍洛旗', '140010008', '140010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013038723502080, '巴彦淖尔市', '巴彦淖尔市', '140011', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013038723502081, '临河区', '临河区', '140011001', '140011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013038987743233, '五原县', '五原县', '140011002', '140011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013039134543873, '磴口县', '磴口县', '140011003', '140011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013039272955905, '乌拉特前旗', '乌拉特前旗', '140011004', '140011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013039419756545, '乌拉特中旗', '乌拉特中旗', '140011005', '140011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013039570751489, '乌拉特后旗', '乌拉特后旗', '140011006', '140011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013039725940737, '杭锦后旗', '杭锦后旗', '140011007', '140011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013039876935680, '阿拉善盟', '阿拉善盟', '140012', '140', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013039876935681, '阿拉善左旗', '阿拉善左旗', '140012001', '140012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013040107622401, '阿拉善右旗', '阿拉善右旗', '140012002', '140012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013040246034433, '额济纳旗', '额济纳旗', '140012003', '140012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013040405417984, '辽宁省', '辽宁', '150', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013040522858496, '沈阳市', '沈阳市', '150001', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013040522858497, '和平区', '和平区', '150001001', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013040736768001, '沈河区', '沈河区', '150001002', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013040883568641, '大东区', '大东区', '150001003', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013041026174977, '皇姑区', '皇姑区', '150001004', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013041185558529, '铁西区', '铁西区', '150001005', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013041336553473, '苏家屯区', '苏家屯区', '150001006', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013041474965505, '浑南区', '浑南区', '150001007', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013041621766145, '沈北新区', '沈北新区', '150001008', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013041764372481, '于洪区', '于洪区', '150001009', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013041919561729, '辽中区', '辽中区', '150001010', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013042053779457, '康平县', '康平县', '150001011', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013042200580097, '法库县', '法库县', '150001012', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013042343186433, '新民市', '新民市', '150001013', '150001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013042494181376, '大连市', '大连市', '150002', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013042494181377, '中山区', '中山区', '150002001', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013042712285185, '西岗区', '西岗区', '150002002', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013042863280129, '沙河口区', '沙河口区', '150002003', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013043001692161, '甘井子区', '甘井子区', '150002004', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013043148492801, '旅顺口区', '旅顺口区', '150002005', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013043295293441, '金州区', '金州区', '150002006', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013043437899777, '普兰店区', '普兰店区', '150002007', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013043588894721, '瓦房店市', '瓦房店市', '150002008', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013043739889665, '庄河市', '庄河市', '150002009', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013043882496001, '长海县', '长海县', '150002010', '150002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013044033490944, '鞍山市', '鞍山市', '150003', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013044033490945, '铁东区', '铁东区', '150003001', '150003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013044259983361, '铁西区', '铁西区', '150003002', '150003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013044410978305, '立山区', '立山区', '150003003', '150003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013044557778945, '千山区', '千山区', '150003004', '150003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013044704579585, '台安县', '台安县', '150003005', '150003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013044855574529, '岫岩满族自治县', '岫岩满族自治县', '150003006', '150003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013044993986561, '海城市', '海城市', '150003007', '150003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013045140787200, '抚顺市', '抚顺市', '150004', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013045140787201, '新抚区', '新抚区', '150004001', '150004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013045367279617, '东洲区', '东洲区', '150004002', '150004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013045518274561, '望花区', '望花区', '150004003', '150004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013045669269505, '顺城区', '顺城区', '150004004', '150004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013045811875841, '抚顺县', '抚顺县', '150004005', '150004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013045954482177, '新宾满族自治县', '新宾满族自治县', '150004006', '150004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013046105477121, '清原满族自治县', '清原满族自治县', '150004007', '150004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013046252277760, '本溪市', '本溪市', '150005', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013046252277761, '平山区', '平山区', '150005001', '150005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013046478770177, '溪湖区', '溪湖区', '150005002', '150005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013046629765121, '明山区', '明山区', '150005003', '150005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013046780760065, '南芬区', '南芬区', '150005004', '150005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013046927560705, '本溪满族自治县', '本溪满族自治县', '150005005', '150005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013047078555649, '桓仁满族自治县', '桓仁满族自治县', '150005006', '150005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013047233744896, '丹东市', '丹东市', '150006', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013047233744897, '元宝区', '元宝区', '150006001', '150006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013047456043009, '振兴区', '振兴区', '150006002', '150006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013047607037953, '振安区', '振安区', '150006003', '150006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013047758032897, '宽甸满族自治县', '宽甸满族自治县', '150006004', '150006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013047909027841, '东港市', '东港市', '150006005', '150006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013048055828481, '凤城市', '凤城市', '150006006', '150006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013048211017728, '锦州市', '锦州市', '150007', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013048211017729, '古塔区', '古塔区', '150007001', '150007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013048424927233, '凌河区', '凌河区', '150007002', '150007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013048580116481, '太和区', '太和区', '150007003', '150007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013048726917121, '黑山县', '黑山县', '150007004', '150007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013048882106369, '义县', '义县', '150007005', '150007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013049024712705, '凌海市', '凌海市', '150007006', '150007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013049171513345, '北镇市', '北镇市', '150007007', '150007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013049318313984, '营口市', '营口市', '150008', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013049318313985, '站前区', '站前区', '150008001', '150008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013049549000705, '西市区', '西市区', '150008002', '150008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013049699995649, '鲅鱼圈区', '鲅鱼圈区', '150008003', '150008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013049859379201, '老边区', '老边区', '150008004', '150008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013050006179841, '盖州市', '盖州市', '150008005', '150008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013050152980481, '大石桥市', '大石桥市', '150008006', '150008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013050299781120, '阜新市', '阜新市', '150009', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013050299781121, '海州区', '海州区', '150009001', '150009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013050530467841, '新邱区', '新邱区', '150009002', '150009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013050681462785, '太平区', '太平区', '150009003', '150009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013050828263425, '清河门区', '清河门区', '150009004', '150009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013050979258369, '细河区', '细河区', '150009005', '150009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013051126059009, '阜新蒙古族自治县', '阜新蒙古族自治县', '150009006', '150009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013051277053953, '彰武县', '彰武县', '150009007', '150009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013051428048896, '辽阳市', '辽阳市', '150010', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013051428048897, '白塔区', '白塔区', '150010001', '150010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013051650347009, '文圣区', '文圣区', '150010002', '150010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013051797147649, '宏伟区', '宏伟区', '150010003', '150010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013051943948289, '弓长岭区', '弓长岭区', '150010004', '150010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013052099137537, '太子河区', '太子河区', '150010005', '150010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013052245938177, '辽阳县', '辽阳县', '150010006', '150010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013052396933121, '灯塔市', '灯塔市', '150010007', '150010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013052547928064, '盘锦市', '盘锦市', '150011', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013052547928065, '双台子区', '双台子区', '150011001', '150011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013052753448961, '兴隆台区', '兴隆台区', '150011002', '150011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013052887666689, '大洼县', '大洼县', '150011003', '150011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013053034467329, '盘山县', '盘山县', '150011004', '150011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013053172879360, '铁岭市', '铁岭市', '150012', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013053172879361, '银州区', '银州区', '150012001', '150012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013053403566081, '清河区', '清河区', '150012002', '150012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013053546172417, '铁岭县', '铁岭县', '150012003', '150012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013053692973057, '西丰县', '西丰县', '150012004', '150012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013053839773697, '昌图县', '昌图县', '150012005', '150012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013053978185729, '调兵山市', '调兵山市', '150012006', '150012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013054124986369, '开原市', '开原市', '150012007', '150012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013054263398400, '朝阳市', '朝阳市', '150013', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013054263398401, '双塔区', '双塔区', '150013001', '150013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013054481502209, '龙城区', '龙城区', '150013002', '150013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013054619914241, '朝阳县', '朝阳县', '150013003', '150013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013054758326273, '建平县', '建平县', '150013004', '150013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013054909321217, '喀喇沁左翼蒙古族自治县', '喀喇沁左翼蒙古族自治县', '150013005', '150013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013055060316161, '北票市', '北票市', '150013006', '150013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013055202922497, '凌源市', '凌源市', '150013007', '150013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013055341334528, '葫芦岛市', '葫芦岛市', '150014', '150', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013055341334529, '连山区', '连山区', '150014001', '150014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013055546855425, '龙港区', '龙港区', '150014002', '150014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013055689461761, '南票区', '南票区', '150014003', '150014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013055840456705, '绥中县', '绥中县', '150014004', '150014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013055987257345, '建昌县', '建昌县', '150014005', '150014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013056129863681, '兴城市', '兴城市', '150014006', '150014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013056276664320, '吉林省', '吉林', '160', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013056389910528, '长春市', '长春市', '160001', '160', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013056389910529, '南关区', '南关区', '160001001', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013056616402945, '宽城区', '宽城区', '160001002', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013056763203585, '朝阳区', '朝阳区', '160001003', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013056922587137, '二道区', '二道区', '160001004', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013057073582081, '绿园区', '绿园区', '160001005', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013057216188417, '双阳区', '双阳区', '160001006', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013057367183361, '九台区', '九台区', '160001007', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013057509789697, '农安县', '农安县', '160001008', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013057669173249, '榆树市', '榆树市', '160001009', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013057828556801, '德惠市', '德惠市', '160001010', '160001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013057987940352, '吉林市', '吉林市', '160002', '160', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013057987940353, '昌邑区', '昌邑区', '160002001', '160002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013058214432769, '龙潭区', '龙潭区', '160002002', '160002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013058361233409, '船营区', '船营区', '160002003', '160002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013058516422657, '丰满区', '丰满区', '160002004', '160002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013058675806209, '永吉县', '永吉县', '160002005', '160002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013058835189761, '蛟河市', '蛟河市', '160002006', '160002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013058990379009, '桦甸市', '桦甸市', '160002007', '160002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013059141373953, '舒兰市', '舒兰市', '160002008', '160002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013059292368897, '磐石市', '磐石市', '160002009', '160002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013059439169536, '四平市', '四平市', '160003', '160', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013059439169537, '铁西区', '铁西区', '160003001', '160003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013059657273345, '铁东区', '铁东区', '160003002', '160003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013059804073985, '梨树县', '梨树县', '160003003', '160003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013059950874625, '伊通满族自治县', '伊通满族自治县', '160003004', '160003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013060106063873, '公主岭市', '公主岭市', '160003005', '160003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013060261253121, '双辽市', '双辽市', '160003006', '160003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013060416442368, '辽源市', '辽源市', '160004', '160', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013060416442369, '龙山区', '龙山区', '160004001', '160004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013060638740481, '西安区', '西安区', '160004002', '160004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013060789735425, '东丰县', '东丰县', '160004003', '160004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013060940730369, '东辽县', '东辽县', '160004004', '160004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013061087531008, '通化市', '通化市', '160005', '160', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013061087531009, '东昌区', '东昌区', '160005001', '160005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013061301440513, '二道江区', '二道江区', '160005002', '160005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013061456629761, '通化县', '通化县', '160005003', '160005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013061607624705, '辉南县', '辉南县', '160005004', '160005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013061754425345, '柳河县', '柳河县', '160005005', '160005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013061901225985, '梅河口市', '梅河口市', '160005006', '160005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013062052220929, '集安市', '集安市', '160005007', '160005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013062207410176, '白山市', '白山市', '160006', '160', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013062207410177, '浑江区', '浑江区', '160006001', '160006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013062442291201, '江源区', '江源区', '160006002', '160006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013062593286145, '抚松县', '抚松县', '160006003', '160006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013062735892481, '靖宇县', '靖宇县', '160006004', '160006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013062878498817, '长白朝鲜族自治县', '长白朝鲜族自治县', '160006005', '160006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013063029493761, '临江市', '临江市', '160006006', '160006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013063176294400, '松原市', '松原市', '160007', '160', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013063176294401, '宁江区', '宁江区', '160007001', '160007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013063406981121, '前郭尔罗斯蒙古族自治县', '前郭尔罗斯蒙古族自治县', '160007002', '160007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013063553781761, '长岭县', '长岭县', '160007003', '160007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013063708971009, '乾安县', '乾安县', '160007004', '160007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013063864160257, '扶余市', '扶余市', '160007005', '160007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013064015155200, '白城市', '白城市', '160008', '160', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013064015155201, '洮北区', '洮北区', '160008001', '160008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013064237453313, '镇赉县', '镇赉县', '160008002', '160008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013064380059649, '通榆县', '通榆县', '160008003', '160008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013064531054593, '洮南市', '洮南市', '160008004', '160008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013064686243841, '大安市', '大安市', '160008005', '160008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013064828850176, '延边朝鲜族自治州', '延边朝鲜族自治州', '160009', '160', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013064828850177, '延吉市', '延吉市', '160009001', '160009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013065042759681, '图们市', '图们市', '160009002', '160009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013065193754625, '敦化市', '敦化市', '160009003', '160009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013065344749569, '珲春市', '珲春市', '160009004', '160009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013065478967297, '龙井市', '龙井市', '160009005', '160009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013065625767937, '和龙市', '和龙市', '160009006', '160009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013065776762881, '汪清县', '汪清县', '160009007', '160009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013065931952129, '安图县', '安图县', '160009008', '160009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013066078752768, '黑龙江省', '黑龙江', '170', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013066191998976, '哈尔滨市', '哈尔滨市', '170001', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013066191998977, '道里区', '道里区', '170001001', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013066435268609, '南岗区', '南岗区', '170001002', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013066586263553, '道外区', '道外区', '170001003', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013066749841409, '松北区', '松北区', '170001004', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013066896642049, '香坊区', '香坊区', '170001005', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013067051831297, '阿成区', '阿成区', '170001006', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013067198631937, '平房区', '平房区', '170001007', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013067349626881, '呼兰区', '呼兰区', '170001008', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013067488038913, '双城区', '双城区', '170001009', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013067639033857, '依兰县', '依兰县', '170001010', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013067802611713, '方正县', '方正县', '170001011', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013067949412353, '宾县', '宾县', '170001012', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013068104601601, '巴彦县', '巴彦县', '170001013', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013068255596545, '木兰县', '木兰县', '170001014', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013068410785793, '通河县', '通河县', '170001015', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013068570169345, '延寿县', '延寿县', '170001016', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013068733747201, '尚志市', '尚志市', '170001017', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013068884742145, '五常市', '五常市', '170001018', '170001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013069031542784, '齐齐哈尔市', '齐齐哈尔市', '170002', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013069031542785, '龙沙区', '龙沙区', '170002001', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013069258035201, '建华区', '建华区', '170002002', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013069417418753, '铁锋区', '铁锋区', '170002003', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013069564219393, '昂昂溪区', '昂昂溪区', '170002004', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013069715214337, '富拉尔基区', '富拉尔基区', '170002005', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013069862014977, '碾子山区', '碾子山区', '170002006', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013070013009921, '梅里斯达斡尔族区', '梅里斯达斡尔族区', '170002007', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013070172393473, '龙江县', '龙江县', '170002008', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013070323388417, '依安县', '依安县', '170002009', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013070470189057, '泰来县', '泰来县', '170002010', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013070625378305, '甘南县', '甘南县', '170002011', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013070763790337, '富裕县', '富裕县', '170002012', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013070914785281, '克山县', '克山县', '170002013', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013071069974529, '克东县', '克东县', '170002014', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013071220969473, '拜泉县', '拜泉县', '170002015', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013071367770113, '讷河市', '讷河市', '170002016', '170002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013071522959360, '鸡西市', '鸡西市', '170003', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013071522959361, '鸡冠区', '鸡冠区', '170003001', '170003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013071745257473, '恒山区', '恒山区', '170003002', '170003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013071896252417, '滴道区', '滴道区', '170003003', '170003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013072059830273, '梨树区', '梨树区', '170003004', '170003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013072206630913, '城子河区', '城子河区', '170003005', '170003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013072353431553, '麻山区', '麻山区', '170003006', '170003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013072508620801, '鸡东县', '鸡东县', '170003007', '170003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013072655421441, '虎林市', '虎林市', '170003008', '170003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013072806416385, '密山市', '密山市', '170003009', '170003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013072961605632, '鹤岗市', '鹤岗市', '170004', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013072961605633, '向阳区', '向阳区', '170004001', '170004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013073188098049, '工农区', '工农区', '170004002', '170004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013073334898689, '南山区', '南山区', '170004003', '170004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013073481699329, '兴安区', '兴安区', '170004004', '170004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013073636888577, '东山区', '东山区', '170004005', '170004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013073796272129, '兴山区', '兴山区', '170004006', '170004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013073943072769, '萝北县', '萝北县', '170004007', '170004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013074089873409, '绥滨县', '绥滨县', '170004008', '170004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013074236674048, '双鸭山市', '双鸭山市', '170005', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013074236674049, '尖山区', '尖山区', '170005001', '170005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013074471555073, '岭东区', '岭东区', '170005002', '170005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013074630938625, '四方台区', '四方台区', '170005003', '170005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013074786127873, '宝山区', '宝山区', '170005004', '170005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013074924539905, '集贤县', '集贤县', '170005005', '170005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013075075534849, '友谊县', '友谊县', '170005006', '170005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013075218141185, '宝清县', '宝清县', '170005007', '170005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013075364941825, '饶河县', '饶河县', '170005008', '170005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013075520131072, '大庆市', '大庆市', '170006', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013075520131073, '萨尔图区', '萨尔图区', '170006001', '170006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013075734040577, '龙凤区', '龙凤区', '170006002', '170006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013075872452609, '让胡路区', '让胡路区', '170006003', '170006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013076044419073, '红岗区', '红岗区', '170006004', '170006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013076187025409, '大同区', '大同区', '170006005', '170006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013076333826049, '肇州县', '肇州县', '170006006', '170006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013076489015297, '肇源县', '肇源县', '170006007', '170006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013076640010241, '林甸县', '林甸县', '170006008', '170006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013076786810881, '杜尔伯特蒙古族自治县', '杜尔伯特蒙古族自治县', '170006009', '170006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013076933611520, '伊春市', '伊春市', '170007', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013076933611521, '伊春区', '伊春区', '170007001', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013077164298241, '南岔区', '南岔区', '170007002', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013077315293185, '友好区', '友好区', '170007003', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013077466288129, '西林区', '西林区', '170007004', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013077621477377, '翠峦区', '翠峦区', '170007005', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013077768278017, '新青区', '新青区', '170007006', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013077919272961, '美溪区', '美溪区', '170007007', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013078066073601, '金山屯区', '金山屯区', '170007008', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013078212874241, '五营区', '五营区', '170007009', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013078363869185, '乌马河区', '乌马河区', '170007010', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013078510669825, '汤旺河区', '汤旺河区', '170007011', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013078665859073, '带岭区', '带岭区', '170007012', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013078816854017, '乌伊岭区', '乌伊岭区', '170007013', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013078963654657, '红星区', '红星区', '170007014', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013079118843905, '上甘岭区', '上甘岭区', '170007015', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013079265644545, '嘉荫县', '嘉荫县', '170007016', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013079420833793, '铁力市', '铁力市', '170007017', '170007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013079588605952, '佳木斯市', '佳木斯市', '170008', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013079588605953, '向阳区', '向阳区', '170008001', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013079831875585, '前进区', '前进区', '170008002', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013079991259137, '东风区', '东风区', '170008003', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013080142254081, '郊区', '郊区', '170008004', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013080310026241, '桦南县', '桦南县', '170008005', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013080461021185, '桦川县', '桦川县', '170008006', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013080616210433, '汤原县', '汤原县', '170008007', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013080754622465, '抚远市', '抚远市', '170008008', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013080909811713, '同江市', '同江市', '170008009', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013081056612353, '富锦市', '富锦市', '170008010', '170008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013081211801600, '七台河市', '七台河市', '170009', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013081211801601, '新兴区', '新兴区', '170009001', '170009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013081438294017, '桃山区', '桃山区', '170009002', '170009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013081576706049, '茄子河区', '茄子河区', '170009003', '170009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013081736089601, '勃利县', '勃利县', '170009004', '170009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013081891278848, '牡丹江市', '牡丹江市', '170010', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013081891278849, '东安区', '东安区', '170010001', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013082113576961, '阳明区', '阳明区', '170010002', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013082264571905, '爱民区', '爱民区', '170010003', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013082415566849, '西安区', '西安区', '170010004', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013082562367489, '东宁市', '东宁市', '170010005', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013082717556737, '林口县', '林口县', '170010006', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013082868551681, '绥芬河市', '绥芬河市', '170010007', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013083015352321, '海林市', '海林市', '170010008', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013083166347265, '宁安市', '宁安市', '170010009', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013083313147905, '穆棱市', '穆棱市', '170010010', '170010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013083464142848, '黑河市', '黑河市', '170011', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013083464142849, '爱辉区', '爱辉区', '170011001', '170011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013083694829569, '嫩江县', '嫩江县', '170011002', '170011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013083862601729, '逊克县', '逊克县', '170011003', '170011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013084017790977, '孙吴县', '孙吴县', '170011004', '170011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013084164591617, '北安市', '北安市', '170011005', '170011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013084319780865, '五大连池市', '五大连池市', '170011006', '170011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013084458192896, '绥化市', '绥化市', '170012', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013084458192897, '北林区', '北林区', '170012001', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013084688879617, '安达市', '安达市', '170012002', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013084835680257, '肇东市', '肇东市', '170012003', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013084982480897, '海伦市', '海伦市', '170012004', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013085129281537, '望奎县', '望奎县', '170012005', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013085280276481, '兰西县', '兰西县', '170012006', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013085431271425, '青冈县', '青冈县', '170012007', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013085590654977, '庆安县', '庆安县', '170012008', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013085737455617, '明水县', '明水县', '170012009', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013085892644865, '绥棱县', '绥棱县', '170012010', '170012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013086043639808, '大兴安岭地区', '大兴安岭地区', '170013', '170', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013086043639809, '呼玛县', '呼玛县', '170013001', '170013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013086278520833, '塔河县', '塔河县', '170013002', '170013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013086421127169, '漠河县', '漠河县', '170013003', '170013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013086580510721, '加格达奇区', '加格达奇区', '170013004', '170013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013086731505665, '松岭区', '松岭区', '170013005', '170013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013086878306305, '新林区', '新林区', '170013006', '170013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013087037689857, '呼中区', '呼中区', '170013007', '170013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013087197073408, '上海市', '上海', '180', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013087310319616, '上海市', '上海市', '180001', '180', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013087310319617, '黄浦区', '黄浦区', '180001001', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013087536812033, '徐汇区', '徐汇区', '180001002', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013087696195585, '长宁区', '长宁区', '180001003', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013087901716481, '杨浦区', '杨浦区', '180001004', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013088056905729, '虹口区', '虹口区', '180001005', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013088207900673, '闵行区', '闵行区', '180001006', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013088358895617, '普陀区', '普陀区', '180001007', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013088514084865, '宝山区', '宝山区', '180001008', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013088665079809, '静安区', '静安区', '180001009', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013088816074753, '松江区', '松江区', '180001010', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013088971264001, '嘉定区', '嘉定区', '180001011', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013089126453249, '金山区', '金山区', '180001012', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013089273253889, '青浦区', '青浦区', '180001013', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013089424248833, '奉贤区', '奉贤区', '180001014', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013089566855169, '浦东新区', '浦东新区', '180001015', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013089722044417, '崇明区', '崇明区', '180001016', '180001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013089873039360, '江苏省', '江苏', '190', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013089990479872, '南京市', '南京市', '190001', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013089990479873, '玄武区', '玄武区', '190001001', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013090212777985, '秦淮区', '秦淮区', '190001002', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013090351190017, '建邺区', '建邺区', '190001003', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013090502184961, '鼓楼区', '鼓楼区', '190001004', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013090653179905, '浦口区', '浦口区', '190001005', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013090804174849, '栖霞区', '栖霞区', '190001006', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013090967752705, '雨花台区', '雨花台区', '190001007', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013091114553345, '江宁区', '江宁区', '190001008', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013091261353985, '六合区', '六合区', '190001009', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013091403960321, '溧水区', '溧水区', '190001010', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013091563343873, '高淳区', '高淳区', '190001011', '190001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013091726921728, '无锡市', '无锡市', '190002', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013091726921729, '滨湖区', '滨湖区', '190002001', '190002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013091953414145, '梁溪区', '梁溪区', '190002002', '190002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013092096020481, '锡山区', '锡山区', '190002003', '190002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013092238626817, '惠山区', '惠山区', '190002004', '190002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013092385427457, '新吴区', '新吴区', '190002005', '190002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013092544811009, '江阴市', '江阴市', '190002006', '190002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013092695805953, '宜兴市', '宜兴市', '190002007', '190002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013092960047104, '徐州市', '徐州市', '190003', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013092960047105, '鼓楼区', '鼓楼区', '190003001', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013093182345217, '云龙区', '云龙区', '190003002', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013093337534465, '贾汪区', '贾汪区', '190003003', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013093492723713, '泉山区', '泉山区', '190003004', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013093647912961, '铜山区', '铜山区', '190003005', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013093798907905, '丰县', '丰县', '190003006', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013093949902849, '沛县', '沛县', '190003007', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013094088314881, '睢宁县', '睢宁县', '190003008', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013094239309825, '新沂市', '新沂市', '190003009', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013094390304769, '邳州市', '邳州市', '190003010', '190003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013094545494016, '常州市', '常州市', '190004', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013094545494017, '天宁区', '天宁区', '190004001', '190004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013094788763649, '钟楼区', '钟楼区', '190004002', '190004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013094935564289, '新北区', '新北区', '190004003', '190004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013095082364929, '武进区', '武进区', '190004004', '190004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013095237554177, '金坛区', '金坛区', '190004005', '190004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013095388549121, '溧阳市', '溧阳市', '190004006', '190004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013095531155456, '苏州市', '苏州市', '190005', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013095531155457, '姑苏区', '姑苏区', '190005001', '190005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013095757647873, '虎丘区', '虎丘区', '190005002', '190005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013095908642817, '吴中区', '吴中区', '190005003', '190005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013096055443457, '相城区', '相城区', '190005004', '190005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013096206438401, '吴江区', '吴江区', '190005005', '190005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013096361627649, '常熟市', '常熟市', '190005006', '190005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013096508428289, '张家港市', '张家港市', '190005007', '190005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013096659423233, '昆山市', '昆山市', '190005008', '190005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013096806223873, '太仓市', '太仓市', '190005009', '190005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013096961413120, '南通市', '南通市', '190006', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013096961413121, '崇川区', '崇川区', '190006001', '190006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013097187905537, '港闸区', '港闸区', '190006002', '190006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013097334706177, '通州区', '通州区', '190006003', '190006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013097485701121, '如东县', '如东县', '190006004', '190006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013097624113153, '海安县', '海安县', '190006005', '190006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013097770913793, '启东市', '启东市', '190006006', '190006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013097917714433, '如皋市', '如皋市', '190006007', '190006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013098081292289, '海门市', '海门市', '190006008', '190006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013098236481536, '连云港市', '连云港市', '190007', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013098236481537, '连云区', '连云区', '190007001', '190007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013098467168257, '赣榆区', '赣榆区', '190007002', '190007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013098609774593, '新浦区', '新浦区', '190007003', '190007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013098760769537, '东海县', '东海县', '190007004', '190007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013098915958785, '灌云县', '灌云县', '190007005', '190007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013099062759425, '灌南县', '灌南县', '190007006', '190007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013099213754368, '淮安市', '淮安市', '190008', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013099213754369, '淮安区', '淮安区', '190008001', '190008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013099440246785, '清江浦区', '清江浦区', '190008002', '190008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013099587047425, '淮阴区', '淮阴区', '190008003', '190008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013099742236673, '洪泽区', '洪泽区', '190008004', '190008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013099889037313, '涟水县', '涟水县', '190008005', '190008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013100035837953, '盱眙县', '盱眙县', '190008006', '190008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013100178444289, '金湖县', '金湖县', '190008007', '190008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013100329439232, '盐城市', '盐城市', '190009', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013100329439233, '亭湖区', '亭湖区', '190009001', '190009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013100564320257, '大丰区', '大丰区', '190009002', '190009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013100715315201, '盐都区', '盐都区', '190009003', '190009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013100866310145, '响水县', '响水县', '190009004', '190009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013101017305089, '滨海县', '滨海县', '190009005', '190009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013101164105729, '阜宁县', '阜宁县', '190009006', '190009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013101310906369, '射阳县', '射阳县', '190009007', '190009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013101457707009, '建湖县', '建湖县', '190009008', '190009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013101608701953, '东台市', '东台市', '190009009', '190009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013101755502592, '扬州市', '扬州市', '190010', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013101755502593, '广陵区', '广陵区', '190010001', '190010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013101986189313, '江都区', '江都区', '190010002', '190010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013102137184257, '邗江区', '邗江区', '190010003', '190010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013102275596289, '宝应县', '宝应县', '190010004', '190010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013102443368449, '仪征市', '仪征市', '190010005', '190010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013102594363393, '高邮市', '高邮市', '190010006', '190010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013102736969728, '镇江市', '镇江市', '190011', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013102736969729, '京口区', '京口区', '190011001', '190011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013102959267841, '润州区', '润州区', '190011002', '190011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013103106068481, '丹徒区', '丹徒区', '190011003', '190011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013103261257729, '丹阳市', '丹阳市', '190011004', '190011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013103399669761, '扬中市', '扬中市', '190011005', '190011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013103554859009, '句容市', '句容市', '190011006', '190011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013103710048256, '泰州市', '泰州市', '190012', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013103710048257, '海陵区', '海陵区', '190012001', '190012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013103940734977, '高港区', '高港区', '190012002', '190012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013104091729921, '姜堰区', '姜堰区', '190012003', '190012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013104242724865, '兴化市', '兴化市', '190012004', '190012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013104397914113, '靖江市', '靖江市', '190012005', '190012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013104544714753, '泰兴市', '泰兴市', '190012006', '190012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013104695709696, '宿迁市', '宿迁市', '190013', '190', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013104695709697, '宿城区', '宿城区', '190013001', '190013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013104922202113, '宿豫区', '宿豫区', '190013002', '190013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013105077391361, '沭阳县', '沭阳县', '190013003', '190013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013105232580609, '泗阳县', '泗阳县', '190013004', '190013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013105429712897, '泗洪县', '泗洪县', '190013005', '190013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013105580707840, '浙江省', '浙江', '200', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013105689759744, '杭州市', '杭州市', '200001', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013105689759745, '上城区', '上城区', '200001001', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013105949806593, '下城区', '下城区', '200001002', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013106163716097, '江干区', '江干区', '200001003', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013106318905345, '拱墅区', '拱墅区', '200001004', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013106469900289, '西湖区', '西湖区', '200001005', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013106620895233, '滨江区', '滨江区', '200001006', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013106771890177, '余杭区', '余杭区', '200001007', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013106927079425, '富阳区', '富阳区', '200001008', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013107086462977, '萧山市', '萧山市', '200001009', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013107241652225, '桐庐县', '桐庐县', '200001010', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013107388452865, '淳安县', '淳安县', '200001011', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013107535253505, '建德市', '建德市', '200001012', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013107682054145, '临安市', '临安市', '200001013', '200001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013107841437696, '宁波市', '宁波市', '200002', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013107841437697, '海曙区', '海曙区', '200002001', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013108072124417, '江北区', '江北区', '200002002', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013108214730753, '北仑区', '北仑区', '200002003', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013108361531393, '镇海区', '镇海区', '200002004', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013108508332033, '鄞州区', '鄞州区', '200002005', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013108659326977, '奉化区', '奉化区', '200002006', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013108810321921, '象山县', '象山县', '200002007', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013108961316865, '宁海县', '宁海县', '200002008', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013109116506113, '余姚市', '余姚市', '200002009', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013109267501057, '慈溪市', '慈溪市', '200002010', '200002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013109414301696, '温州市', '温州市', '200003', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013109414301697, '鹿城区', '鹿城区', '200003001', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013109640794113, '龙湾区', '龙湾区', '200003002', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013109787594753, '瓯海区', '瓯海区', '200003003', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013109930201089, '洞头区', '洞头区', '200003004', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013110081196033, '永嘉县', '永嘉县', '200003005', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013110223802369, '平阳县', '平阳县', '200003006', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013110374797313, '苍南县', '苍南县', '200003007', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013110542569473, '文成县', '文成县', '200003008', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013110697758721, '泰顺县', '泰顺县', '200003009', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013110848753665, '瑞安市', '瑞安市', '200003010', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013110999748609, '乐清市', '乐清市', '200003011', '200003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013111146549248, '嘉兴市', '嘉兴市', '200004', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013111146549249, '南湖区', '南湖区', '200004001', '200004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013111373041665, '秀洲区', '秀洲区', '200004002', '200004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013111519842305, '嘉善县', '嘉善县', '200004003', '200004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013111675031553, '海盐县', '海盐县', '200004004', '200004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013111821832193, '海宁市', '海宁市', '200004005', '200004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013111964438529, '平湖市', '平湖市', '200004006', '200004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013112119627777, '桐乡市', '桐乡市', '200004007', '200004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013112270622720, '湖州市', '湖州市', '200005', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013112270622721, '吴兴区', '吴兴区', '200005001', '200005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013112501309441, '南浔区', '南浔区', '200005002', '200005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013112656498689, '德清县', '德清县', '200005003', '200005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013112807493633, '长兴县', '长兴县', '200005004', '200005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013112950099969, '安吉县', '安吉县', '200005005', '200005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013113101094912, '绍兴市', '绍兴市', '200006', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013113101094913, '越城区', '越城区', '200006001', '200006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013113323393025, '柯桥区', '柯桥区', '200006002', '200006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013113470193665, '上虞区', '上虞区', '200006003', '200006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013113646354433, '新昌县', '新昌县', '200006004', '200006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013113797349377, '诸暨市', '诸暨市', '200006005', '200006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013113944150017, '嵊州市', '嵊州市', '200006006', '200006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013114090950656, '金华市', '金华市', '200007', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013114090950657, '婺城区', '婺城区', '200007001', '200007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013114325831681, '金东区', '金东区', '200007002', '200007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013114481020929, '武义县', '武义县', '200007003', '200007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013114623627265, '浦江县', '浦江县', '200007004', '200007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013114778816513, '磐安县', '磐安县', '200007005', '200007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013114934005761, '兰溪市', '兰溪市', '200007006', '200007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013115076612097, '义乌市', '义乌市', '200007007', '200007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013115223412737, '东阳市', '东阳市', '200007008', '200007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013115374407681, '永康市', '永康市', '200007009', '200007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013115529596928, '衢州市', '衢州市', '200008', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013115529596929, '柯城区', '柯城区', '200008001', '200008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013115751895041, '衢江区', '衢江区', '200008002', '200008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013115894501377, '常山县', '常山县', '200008003', '200008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013116045496321, '开化县', '开化县', '200008004', '200008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013116192296961, '龙游县', '龙游县', '200008005', '200008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013116343291905, '江山市', '江山市', '200008006', '200008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013116485898240, '舟山市', '舟山市', '200009', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013116485898241, '定海区', '定海区', '200009001', '200009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013116716584961, '普陀区', '普陀区', '200009002', '200009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013116871774209, '岱山县', '岱山县', '200009003', '200009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013117026963457, '嵊泗县', '嵊泗县', '200009004', '200009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013117173764096, '台州市', NULL, '200010', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013117173764097, '椒江区', '椒江区', '200010001', '200010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013117400256513, '黄岩区', '黄岩区', '200010002', '200010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013117555445761, '路桥区', '路桥区', '200010003', '200010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013117710635009, '玉环县', '玉环县', '200010004', '200010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013117861629953, '三门县', '三门县', '200010005', '200010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013118021013505, '天台县', '天台县', '200010006', '200010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013118184591361, '仙居县', '仙居县', '200010007', '200010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013118335586305, '温岭市', '温岭市', '200010008', '200010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013118486581249, '临海市', '临海市', '200010009', '200010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013118637576192, '丽水市', NULL, '200011', '200', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013118637576193, '莲都区', '莲都区', '200011001', '200011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013118859874305, '龙泉市', '龙泉市', '200011002', '200011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013119010869249, '青田县', '青田县', '200011003', '200011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013119442882561, '云和县', '云和县', '200011004', '200011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013119593877505, '庆元县', '庆元县', '200011005', '200011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013119728095233, '缙云县', '缙云县', '200011006', '200011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013119874895873, '遂昌县', '遂昌县', '200011007', '200011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013120013307905, '松阳县', '松阳县', '200011008', '200011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013120155914241, '景宁畲族自治县', '景宁畲族自治县', '200011009', '200011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013120298520576, '安徽省', '安徽', '210', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013120411766784, '合肥市', NULL, '210001', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013120411766785, '包河区', '包河区', '210001001', '210001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013120638259201, '蜀山区', '蜀山区', '210001002', '210001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013120780865537, '庐阳区', '庐阳区', '210001003', '210001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013120927666177, '瑶海区', '瑶海区', '210001004', '210001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013121074466817, '庐江县', '庐江县', '210001005', '210001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013121229656065, '长丰县', '长丰县', '210001006', '210001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013121376456705, '肥东县', '肥东县', '210001007', '210001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013121531645953, '肥西县', '肥西县', '210001008', '210001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013121682640897, '巢湖市', '巢湖市', '210001009', '210001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013121825247232, '芜湖市', NULL, '210002', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013121825247233, '镜湖区', '镜湖区', '210002001', '210002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013122047545345, '弋江区', '弋江区', '210002002', '210002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013122194345985, '三山区', '三山区', '210002003', '210002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013122341146625, '鸠江区', '鸠江区', '210002004', '210002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013122496335873, '芜湖县', '芜湖县', '210002005', '210002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013122647330817, '繁昌县', '繁昌县', '210002006', '210002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013122794131457, '无为县', '无为县', '210002007', '210002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013122940932097, '南陵县', '南陵县', '210002008', '210002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013123104509952, '蚌埠市', NULL, '210003', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013123104509953, '龙子湖区', '龙子湖区', '210003001', '210003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013123322613761, '蚌山区', '蚌山区', '210003002', '210003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013123465220097, '禹会区', '禹会区', '210003003', '210003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013123616215041, '淮上区', '淮上区', '210003004', '210003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013123758821377, '怀远县', '怀远县', '210003005', '210003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013123914010625, '五河县', '五河县', '210003006', '210003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013124048228353, '固镇县', '固镇县', '210003007', '210003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013124195028992, '淮南市', NULL, '210004', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013124195028993, '大通区', '大通区', '210004001', '210004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013124413132801, '田家庵区', '田家庵区', '210004002', '210004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013124559933441, '谢家集区', '谢家集区', '210004003', '210004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013124736094209, '八公山区', '八公山区', '210004004', '210004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013124891283457, '潘集区', '潘集区', '210004005', '210004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013125038084097, '寿县', '寿县', '210004006', '210004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013125184884737, '凤台县', '凤台县', '210004007', '210004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013125327491072, '马鞍山市', NULL, '210005', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013125327491073, '博望区', '博望区', '210005001', '210005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013125553983489, '花山区', '花山区', '210005002', '210005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013125704978433, '雨山区', '雨山区', '210005003', '210005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013125860167681, '和县', '和县', '210005004', '210005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013126011162625, '含山县', '含山县', '210005005', '210005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013126153768961, '当涂县', '当涂县', '210005006', '210005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013126304763904, '淮北市', NULL, '210006', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013126304763905, '杜集区', '杜集区', '210006001', '210006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013126527062017, '相山区', '相山区', '210006002', '210006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013126673862657, '烈山区', '烈山区', '210006003', '210006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013126829051905, '濉溪县', '濉溪县', '210006004', '210006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013126971658240, '铜陵市', NULL, '210007', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013126971658241, '铜官区', '铜官区', '210007001', '210007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013127198150657, '义安区', '义安区', '210007002', '210007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013127349145601, '郊区', '郊区', '210007003', '210007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013127491751937, '枞阳县', '枞阳县', '210007004', '210007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013127646941184, '安庆市', NULL, '210008', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013127646941185, '迎江区', '迎江区', '210008001', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013127873433601, '大观区', '大观区', '210008002', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013128016039937, '宜秀区', '宜秀区', '210008003', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013128162840577, '怀宁县', '怀宁县', '210008004', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013128313835521, '潜山县', '潜山县', '210008005', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013128464830465, '太湖县', '太湖县', '210008006', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013128603242497, '宿松县', NULL, '210008007', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013128754237441, '望江县', NULL, '210008008', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013128901038081, '岳西县', NULL, '210008009', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013129056227329, '桐城市', NULL, '210008010', '210008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013129198833664, '黄山市', NULL, '210009', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013129198833665, '屯溪区', NULL, '210009001', '210009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013129425326081, '黄山区', NULL, '210009002', '210009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013129576321025, '徽州区', NULL, '210009003', '210009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013129718927361, '歙县', NULL, '210009004', '210009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013129869922305, '休宁县', NULL, '210009005', '210009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013130012528641, '黟县', NULL, '210009006', '210009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013130159329281, '祁门县', NULL, '210009007', '210009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013130310324224, '滁州市', NULL, '210010', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013130310324225, '琅琊区', NULL, '210010001', '210010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013130541010945, '南谯区', NULL, '210010002', '210010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013130700394497, '来安县', NULL, '210010003', '210010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013130847195137, '全椒县', NULL, '210010004', '210010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013131002384385, '定远县', NULL, '210010005', '210010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013131157573633, '凤阳县', NULL, '210010006', '210010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013131308568577, '天长市', NULL, '210010007', '210010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013131472146433, '明光市', NULL, '210010008', '210010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013131618947072, '阜阳市', NULL, '210011', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013131618947073, '颍州区', NULL, '210011001', '210011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013131849633793, '颍东区', NULL, '210011002', '210011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013132000628737, '颍泉区', NULL, '210011003', '210011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013132147429377, '临泉县', NULL, '210011004', '210011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013132302618625, '太和县', NULL, '210011005', '210011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013132445224961, '阜南县', NULL, '210011006', '210011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013132596219905, '颍上县', NULL, '210011007', '210011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013132751409153, '界首市', NULL, '210011008', '210011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013132898209792, '宿州市', NULL, '210012', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013132898209793, '墉桥区', NULL, '210012001', '210012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013133128896513, '砀山县', NULL, '210012002', '210012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013133288280065, '萧县', NULL, '210012003', '210012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013133443469313, '灵璧县', NULL, '210012004', '210012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013133602852865, '泗县', NULL, '210012005', '210012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013133753847808, '六安市', NULL, '210013', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013133753847809, '金安区', NULL, '210013001', '210013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013133988728833, '裕安区', NULL, '210013002', '210013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013134143918081, '叶集区', NULL, '210013003', '210013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013134307495937, '霍邱县', NULL, '210013004', '210013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013134466879489, '舒城县', NULL, '210013005', '210013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013134634651649, '金寨县', NULL, '210013006', '210013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013134785646593, '霍山县', NULL, '210013007', '210013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013134936641536, '宣城市', NULL, '210014', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013134936641537, '宣州区', NULL, '210014001', '210014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013135158939649, '宁国市', NULL, '210014002', '210014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013135318323201, '郎溪县', NULL, '210014003', '210014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013135473512449, '广德县', NULL, '210014004', '210014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013135649673217, '泾县', NULL, '210014005', '210014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013135804862465, '旌德县', NULL, '210014006', '210014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013135955857409, '绩溪县', NULL, '210014007', '210014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013136102658048, '亳州市', NULL, '210015', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013136102658049, '谯城区', NULL, '210015001', '210015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013136337539073, '涡阳县', NULL, '210015002', '210015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013136480145409, '蒙城县', NULL, '210015003', '210015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013136631140353, '利辛县', NULL, '210015004', '210015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013136777940992, '池州市', NULL, '210016', '210', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013136777940993, '贵池区', NULL, '210016001', '210016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013136996044801, '东至县', NULL, '210016002', '210016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013137151234049, '石台县', NULL, '210016003', '210016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013137298034689, '青阳县', NULL, '210016004', '210016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013137457418240, '福建省', '福建', '220', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013137558081536, '福州市', NULL, '220001', '220', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013137558081537, '鼓楼区', NULL, '220001001', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013137780379649, '台江区', NULL, '220001002', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013137935568897, '仓山区', NULL, '220001003', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013138078175233, '马尾区', NULL, '220001004', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013138229170177, '晋安区', NULL, '220001005', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013138388553729, '闽侯县', NULL, '220001006', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013138531160065, '连江县', NULL, '220001007', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013138690543617, '罗源县', NULL, '220001008', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013138837344257, '闽清县', NULL, '220001009', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013138988339201, '永泰县', NULL, '220001010', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013139130945537, '平潭县', NULL, '220001011', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013139290329089, '福清市', NULL, '220001012', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013139437129729, '长乐市', NULL, '220001013', '220001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013139579736064, '厦门市', NULL, '220002', '220', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013139579736065, '思明区 ', NULL, '220002001', '220002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013139802034177, '海沧区', NULL, '220002002', '220002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013139957223425, '湖里区', NULL, '220002003', '220002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013140112412673, '集美区', NULL, '220002004', '220002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013140263407617, '同安区', NULL, '220002005', '220002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013140410208257, '翔安区', NULL, '220002006', '220002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013140561203200, '宁德市', NULL, '220003', '220', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013140561203201, '蕉城区', NULL, '220003001', '220003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013140783501313, '霞浦县', NULL, '220003002', '220003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013140926107649, '古田县', NULL, '220003003', '220003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013141077102593, '屏南县', NULL, '220003004', '220003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013141219708929, '寿宁县', NULL, '220003005', '220003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013141374898177, '周宁县', NULL, '220003006', '220003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013141521698817, '柘荣县', NULL, '220003007', '220003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013141672693761, '福安市', NULL, '220003008', '220003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013141815300097, '福鼎市', NULL, '220003009', '220003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013141962100736, '莆田市', NULL, '220004', '220', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013141962100737, '城厢区', NULL, '220004001', '220004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013142188593153, '涵江区', NULL, '220004002', '220004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013142339588097, '荔城区', NULL, '220004003', '220004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013142507360257, '秀屿区', NULL, '220004004', '220004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013142662549505, '仙游县', NULL, '220004005', '220004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013142817738752, '泉州市', NULL, '220005', '220', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013142817738753, '鲤城区', NULL, '220005001', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013143052619777, '丰泽区', NULL, '220005002', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013143199420417, '洛江区', NULL, '220005003', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013143346221057, '泉港区', NULL, '220005004', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013143497216001, '惠安县', NULL, '220005005', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013143660793857, '安溪县', NULL, '220005006', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013143803400193, '永春县', NULL, '220005007', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013143954395137, '德化县', NULL, '220005008', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013144109584385, '金门县', NULL, '220005009', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013144264773633, '石狮市', NULL, '220005010', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013144419962881, '晋江市', NULL, '220005011', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013144570957825, '南安市', NULL, '220005012', '220005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013144721952768, '漳州市', NULL, '220006', '220', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013144721952769, '芗城区', NULL, '220006001', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013144981999617, '龙文区', NULL, '220006002', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013145204297729, '云霄县', NULL, '220006003', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013145355292673, '漳浦县', NULL, '220006004', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013145510481921, '诏安县', NULL, '220006005', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013145665671169, '长泰县', NULL, '220006006', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013145808277505, '东山县', NULL, '220006007', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013145950883841, '南靖县', NULL, '220006008', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013146101878785, '平和县', NULL, '220006009', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013146257068033, '华安县', NULL, '220006010', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013146403868673, '龙海市', NULL, '220006011', '220006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013146554863616, '龙岩', NULL, '220007', '220', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013146554863617, '新罗区', NULL, '220007001', '220007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013146785550337, '永定区', NULL, '220007002', '220007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013146936545281, '长汀县', NULL, '220007003', '220007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013147083345921, '上杭县', NULL, '220007004', '220007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013147234340865, '武平县', NULL, '220007005', '220007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013147376947201, '连城县', NULL, '220007006', '220007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013147540525057, '漳平市', NULL, '220007007', '220007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013147691520000, '三明市', NULL, '220008', '220', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013147691520001, '梅列区', NULL, '220008001', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013147918012417, '三元区', NULL, '220008002', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013148064813057, '明溪县', NULL, '220008003', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013148228390913, '清流县', NULL, '220008004', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013148387774465, '宁化县', NULL, '220008005', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013148538769409, '大田县', NULL, '220008006', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013148689764353, '尤溪县', NULL, '220008007', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013148844953601, '沙县', NULL, '220008008', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013149000142849, '将乐县', NULL, '220008009', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013149151137793, '泰宁县', NULL, '220008010', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013149302132737, '建宁县', NULL, '220008011', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013149448933377, '永安市', NULL, '220008012', '220008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013149608316928, '南平市', NULL, '220009', '220', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013149608316929, '延平区', NULL, '220009001', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013149839003649, '建阳区', NULL, '220009002', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013149998387201, '顺昌县', NULL, '220009003', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013150157770753, '浦城县', NULL, '220009004', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013150304571393, '光泽县', NULL, '220009005', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013150451372033, '松溪县', NULL, '220009006', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013150602366977, '政和县', NULL, '220009007', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013150753361921, '邵武市', NULL, '220009008', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013150904356865, '武夷山市', NULL, '220009009', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013151042768897, '建瓯市', NULL, '220009010', '220009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013151185375232, '江西省', '江西', '230', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013151290232832, '南昌市', NULL, '230001', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013151290232833, '东湖区', NULL, '230001001', '230001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013151504142337, '西湖区', NULL, '230001002', '230001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013151659331585, '青云谱区', NULL, '230001003', '230001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013151810326529, '湾里区', NULL, '230001004', '230001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013151957127169, '青山湖区', NULL, '230001005', '230001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013152103927809, '新建区', NULL, '230001006', '230001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013152250728449, '南昌县', NULL, '230001007', '230001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013152397529089, '安义县', NULL, '230001008', '230001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013152548524033, '进贤县', NULL, '230001009', '230001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013152691130368, '景德镇市', NULL, '230002', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013152691130369, '昌江区', NULL, '230002001', '230002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013152913428481, '珠山区', NULL, '230002002', '230002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013153064423425, '浮梁县', NULL, '230002003', '230002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013153207029761, '乐平市', NULL, '230002004', '230002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013153358024704, '萍乡市', NULL, '230003', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013153358024705, '安源区', NULL, '230003001', '230003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013153584517121, '湘东区', NULL, '230003002', '230003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013153735512065, '莲花县', NULL, '230003003', '230003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013153890701313, '上栗县', NULL, '230003004', '230003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013154041696257, '芦溪县', NULL, '230003005', '230003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013154192691200, '九江市', NULL, '230004', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013154192691201, '濂溪区', NULL, '230004001', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013154423377921, '浔阳区', NULL, '230004002', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013154574372865, '九江县', NULL, '230004003', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013154712784897, '武宁县', NULL, '230004004', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013154863779841, '修水县', NULL, '230004005', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013155010580481, '永修县', NULL, '230004006', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013155157381121, '德安县', NULL, '230004007', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013155308376065, '都昌县', NULL, '230004008', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013155455176705, '湖口县', NULL, '230004009', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013155601977345, '彭泽县', NULL, '230004010', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013155757166593, '瑞昌市', NULL, '230004011', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013155903967233, '共青城市', NULL, '230004012', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013156054962177, '庐山市', NULL, '230004013', '230004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013156201762816, '新余市', NULL, '230005', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013156201762817, '渝水区', NULL, '230005001', '230005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013156424060929, '分宜县', NULL, '230005002', '230005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013156575055872, '鹰潭市', NULL, '230006', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013156575055873, '月湖区', NULL, '230006001', '230006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013156793159681, '余江县', NULL, '230006002', '230006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013156944154625, '贵溪市', NULL, '230006003', '230006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013157099343872, '赣州市', NULL, '230007', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013157099343873, '章贡区', NULL, '230007001', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013157321641985, '南康区', NULL, '230007002', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013157464248321, '赣县区', NULL, '230007003', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013157611048961, '信丰县', NULL, '230007004', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013157762043905, '大余县', NULL, '230007005', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013157917233153, '上犹县', NULL, '230007006', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013158072422401, '崇义县', NULL, '230007007', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013158223417345, '安远县', NULL, '230007008', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013158378606593, '龙南县', NULL, '230007009', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013158529601537, '定南县', NULL, '230007010', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013158676402177, '全南县', NULL, '230007011', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013158831591425, '宁都县', NULL, '230007012', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013158974197761, '于都县', NULL, '230007013', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013159125192705, '兴国县', NULL, '230007014', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013159267799041, '会昌县', NULL, '230007015', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013159418793985, '寻乌县', NULL, '230007016', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013159569788929, '石城县', NULL, '230007017', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013159724978177, '瑞金市', NULL, '230007018', '230007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013159875973120, '宜春市', NULL, '230008', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013159875973121, '袁州区', NULL, '230008001', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013160102465537, '丰城市', NULL, '230008002', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013160253460481, '樟树市', NULL, '230008003', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013160396066817, '高安市', NULL, '230008004', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013160551256065, '奉新县', NULL, '230008005', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013160706445313, '万载县', NULL, '230008006', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013160865828865, '上高县', NULL, '230008007', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013161025212417, '宜丰县', NULL, '230008008', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013161180401665, '靖安县', NULL, '230008009', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013161327202305, '铜鼓县', NULL, '230008010', '230008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013161474002944, '上饶市', NULL, '230009', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013161474002945, '信州区', NULL, '230009001', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013161708883969, '广丰区', NULL, '230009002', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013161855684609, '上饶县', NULL, '230009003', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013162006679553, '玉山县', NULL, '230009004', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013162153480193, '铅山县', NULL, '230009005', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013162304475137, '横峰县', NULL, '230009006', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013162455470081, '弋阳县', NULL, '230009007', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013162610659329, '余干县', NULL, '230009008', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013162765848577, '波阳县', NULL, '230009009', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013162925232129, '万年县', NULL, '230009010', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013163076227073, '婺源县', NULL, '230009011', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013163231416321, '德兴市', NULL, '230009012', '230009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013163382411264, '吉安市', NULL, '230010', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013163382411265, '吉州区', NULL, '230010001', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013163613097985, '青原区', NULL, '230010002', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013163755704321, '井冈山市', NULL, '230010003', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013163915087873, '吉安县', NULL, '230010004', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013164053499905, '吉水县', NULL, '230010005', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013164204494849, '峡江县', NULL, '230010006', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013164355489793, '新干县', NULL, '230010007', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013164502290433, '永丰县', NULL, '230010008', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013164649091073, '泰和县', NULL, '230010009', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013164800086017, '遂川县', NULL, '230010010', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013164951080961, '万安县', NULL, '230010011', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013165102075905, '安福县', NULL, '230010012', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013165257265153, '永新县', NULL, '230010013', '230010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013165420843008, '抚州市', NULL, '230011', '230', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013165420843009, '临川区', NULL, '230011001', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013165643141121, '南城县', NULL, '230011002', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013165789941761, '黎川县', NULL, '230011003', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013165945131009, '南丰县', NULL, '230011004', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013166096125953, '崇仁县', NULL, '230011005', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013166251315201, '乐安县', NULL, '230011006', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013166402310145, '宜黄县', NULL, '230011007', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013166544916481, '金溪县', NULL, '230011008', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013166700105729, '资溪县', NULL, '230011009', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013166851100673, '东乡县', NULL, '230011010', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013167006289921, '广昌县', NULL, '230011011', '230011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013167169867776, '山东省', '山东', '240', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013167283113984, '济南市', NULL, '240001', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013167283113985, '历下区', NULL, '240001001', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013167513800705, '市中区', NULL, '240001002', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013167660601345, '槐荫区', NULL, '240001003', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013167807401985, '天桥区', NULL, '240001004', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013167954202625, '历城区', NULL, '240001005', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013168113586177, '长清区', NULL, '240001006', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013168247803905, '章丘区', NULL, '240001007', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013168390410241, '济阳县', NULL, '240001008', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013168537210881, '商河县', NULL, '240001009', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013168688205825, '平阴县', NULL, '240001010', '240001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013168839200768, '青岛市', NULL, '240002', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013168839200769, '市南区', NULL, '240002001', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013169065693185, '市北区', NULL, '240002002', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013169220882433, '黄岛区', NULL, '240002003', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013169371877377, '崂山区', NULL, '240002004', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013169522872321, '李沧区', NULL, '240002005', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013169669672961, '城阳区', NULL, '240002006', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013169820667905, '胶州市', NULL, '240002007', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013169975857153, '即墨市', NULL, '240002008', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013170118463489, '平度市', NULL, '240002009', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013170273652737, '莱西市', NULL, '240002010', '240002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013170441424896, '淄博市', NULL, '240003', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013170441424897, '淄川区', NULL, '240003001', '240003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013170672111617, '张店区', NULL, '240003002', '240003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013170814717953, '博山区', NULL, '240003003', '240003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013170961518593, '临淄区', NULL, '240003004', '240003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013171112513537, '周村区', NULL, '240003005', '240003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013171255119873, '桓台县', NULL, '240003006', '240003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013171401920513, '高青县', NULL, '240003007', '240003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013171552915457, '沂源县', NULL, '240003008', '240003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013171703910400, '枣庄市', NULL, '240004', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013171703910401, '市中区', NULL, '240004001', '240004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013171938791425, '薛城区', NULL, '240004002', '240004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013172085592065, '峄城区', NULL, '240004003', '240004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013172232392705, '台儿庄区', NULL, '240004004', '240004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013172383387649, '山亭区', NULL, '240004005', '240004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013172534382593, '滕州市', NULL, '240004006', '240004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013172681183232, '东营市', NULL, '240005', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013172681183233, '东营区', NULL, '240005001', '240005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013172907675649, '河口区', NULL, '240005002', '240005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013173050281985, '垦利区', NULL, '240005003', '240005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013173192888321, '利津县', NULL, '240005004', '240005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013173339688961, '广饶县', NULL, '240005005', '240005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013173490683904, '烟台市', NULL, '240006', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013173490683905, '芝罘区', NULL, '240006001', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013173717176321, '福山区', NULL, '240006002', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013173868171265, '牟平区', NULL, '240006003', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013174014971905, '莱山区', NULL, '240006004', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013174165966849, '长岛县', NULL, '240006005', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013174304378881, '龙口市', NULL, '240006006', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013174455373825, '莱阳市', NULL, '240006007', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013174602174465, '莱州市', NULL, '240006008', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013174753169409, '蓬莱市', NULL, '240006009', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013174895775745, '招远市', NULL, '240006010', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013175042576385, '栖霞市', NULL, '240006011', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013175197765633, '海阳市', NULL, '240006012', '240006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013175344566272, '潍坊市', NULL, '240007', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013175344566273, '潍城区', NULL, '240007001', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013175554281473, '寒亭区', NULL, '240007002', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013175696887809, '坊子区', NULL, '240007003', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013175835299841, '奎文区', NULL, '240007004', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013175982100481, '临朐县', NULL, '240007005', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013176128901121, '昌乐县', NULL, '240007006', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013176288284673, '青州市', NULL, '240007007', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013176430891009, '诸城市', NULL, '240007008', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013176577691649, '寿光市', NULL, '240007009', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013176728686593, '安丘市', NULL, '240007010', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013176875487233, '高密市', NULL, '240007011', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013177022287873, '昌邑市', NULL, '240007012', '240007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013177173282816, '济宁市', NULL, '240008', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013177173282817, '兖州区', NULL, '240008001', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013177399775233, '任城区', NULL, '240008002', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013177554964481, '微山县', NULL, '240008003', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013177705959425, '鱼台县', NULL, '240008004', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013177856954369, '金乡县', NULL, '240008005', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013178016337921, '嘉祥县', NULL, '240008006', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013178175721473, '汶上县', NULL, '240008007', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013178611929089, '泗水县', NULL, '240008008', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013178767118337, '梁山县', NULL, '240008009', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013178918113281, '曲阜市', NULL, '240008010', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013179064913921, '邹城市', NULL, '240008011', '240008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013179224297472, '泰安市', NULL, '240009', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013179224297473, '泰山区', NULL, '240009001', '240009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013179450789889, '岱岳区', NULL, '240009002', '240009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013179601784833, '宁阳县', NULL, '240009003', '240009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013179756974081, '东平县', NULL, '240009004', '240009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013179912163329, '新泰市', NULL, '240009005', '240009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013180075741185, '肥城市', NULL, '240009006', '240009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013180222541824, '威海市', NULL, '240010', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013180222541825, '环翠区', NULL, '240010001', '240010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013180453228545, '文登区', NULL, '240010002', '240010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013180600029185, '荣成市', NULL, '240010003', '240010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013180746829825, '乳山市', NULL, '240010004', '240010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013180897824768, '日照市', NULL, '240011', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013180897824769, '东港区', NULL, '240011001', '240011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013181103345665, '岚山区', NULL, '240011002', '240011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013181250146305, '五莲县', NULL, '240011003', '240011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013181401141249, '莒县', NULL, '240011004', '240011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013181560524800, '莱芜市', NULL, '240012', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013181560524801, '莱城区', NULL, '240012001', '240012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013181778628609, '钢城区', NULL, '240012002', '240012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013181925429248, '临沂市', NULL, '240013', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013181925429249, '兰山区', NULL, '240013001', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013182151921665, '罗庄区', NULL, '240013002', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013182302916609, '河东区', NULL, '240013003', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013182458105857, '沂南县', NULL, '240013004', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013182604906497, '郯城县', NULL, '240013005', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013182755901441, '沂水县', NULL, '240013006', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013182906896385, '苍山县', NULL, '240013007', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013183057891329, '费县', NULL, '240013008', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013183213080577, '平邑县', NULL, '240013009', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013183351492609, '莒南县', NULL, '240013010', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013183502487553, '蒙阴县', NULL, '240013011', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013183645093889, '临沭县', NULL, '240013012', '240013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013183796088832, '德州市', NULL, '240014', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013183796088833, '德城区', NULL, '240014001', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013184009998337, '陵城区', NULL, '240014002', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013184156798977, '宁津县', NULL, '240014003', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013184303599617, '庆云县', NULL, '240014004', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013184458788865, '临邑县', NULL, '240014005', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013184597200897, '齐河县', NULL, '240014006', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013184739807233, '平原县', NULL, '240014007', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013184882413569, '夏津县', NULL, '240014008', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013185033408513, '武城县', NULL, '240014009', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013185184403457, '乐陵市', NULL, '240014010', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013185339592705, '禹城市', NULL, '240014011', '240014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013185478004736, '聊城市', NULL, '240015', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013185478004737, '东昌府区', NULL, '240015001', '240015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013185696108545, '阳谷县', NULL, '240015002', '240015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013185842909185, '莘县', NULL, '240015003', '240015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013185989709825, '茌平县', NULL, '240015004', '240015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013186149093377, '东阿县', NULL, '240015005', '240015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013186295894017, '冠县', NULL, '240015006', '240015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013186442694657, '高唐县', NULL, '240015007', '240015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013186593689601, '临清市', NULL, '240015008', '240015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013186744684544, '滨州市', NULL, '240016', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013186744684545, '滨城区', NULL, '240016001', '240016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013186987954177, '沾化区', NULL, '240016002', '240016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013187134754817, '惠民县', NULL, '240016003', '240016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013187281555457, '阳信县', NULL, '240016004', '240016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013187424161793, '无棣县', NULL, '240016005', '240016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013187579351041, '博兴县', NULL, '240016006', '240016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013187721957377, '邹平县', NULL, '240016007', '240016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013187868758016, '菏泽市', NULL, '240017', '240', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013187868758017, '牡丹区', NULL, '240017001', '240017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013188103639041, '曹县', NULL, '240017002', '240017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013188242051073, '定陶县', NULL, '240017003', '240017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013188401434625, '成武县', NULL, '240017004', '240017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013188556623873, '单县', NULL, '240017005', '240017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013188699230209, '巨野县', NULL, '240017006', '240017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013188850225153, '郓城县', NULL, '240017007', '240017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013188984442881, '鄄城县', NULL, '240017008', '240017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013189127049217, '东明县', NULL, '240017009', '240017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013189273849856, '河南省', '河南', '250', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013189378707456, '郑州市', NULL, '250001', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013189378707457, '中原区', NULL, '250001001', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013189630365697, '二七区', NULL, '250001002', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013189819109377, '管城回族区', NULL, '250001003', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013189965910017, '金水区', NULL, '250001004', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013190116904961, '上街区', NULL, '250001005', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013190259511297, '惠济区', NULL, '250001006', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013190393729025, '中牟县', NULL, '250001007', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013190548918273, '巩义市', NULL, '250001008', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013190687330305, '荥阳市', NULL, '250001009', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013190817353729, '新密市', NULL, '250001010', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013190964154369, '新郑市', NULL, '250001011', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013191110955009, '登封市', NULL, '250001012', '250001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013191270338560, '开封市', NULL, '250002', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013191270338561, '龙亭区', NULL, '250002001', '250002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013191509413889, '顺河回族区', NULL, '250002002', '250002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013191660408833, '鼓楼区', NULL, '250002003', '250002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013191798820865, '禹王台区', NULL, '250002004', '250002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013191945621505, '祥符区', NULL, '250002005', '250002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013192096616449, '杞县', NULL, '250002006', '250002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013192251805697, '通许县', NULL, '250002007', '250002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013192390217729, '尉氏县', NULL, '250002008', '250002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013192537018369, '兰考县', NULL, '250002009', '250002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013192679624704, '洛阳市', NULL, '250003', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013192679624705, '老城区', NULL, '250003001', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013192901922817, '西工区', NULL, '250003002', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013193048723457, '瀍河回族区', NULL, '250003003', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013193195524097, '涧西区', NULL, '250003004', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013193342324737, '吉利区', NULL, '250003005', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013193489125377, '洛龙区', NULL, '250003006', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013193631731713, '孟津县', NULL, '250003007', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013193782726657, '新安县', NULL, '250003008', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013193937915905, '栾川县', NULL, '250003009', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013194084716545, '嵩县', NULL, '250003010', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013194227322881, '汝阳县', NULL, '250003011', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013194374123521, '宜阳县', NULL, '250003012', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013194512535553, '洛宁县', NULL, '250003013', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013194655141889, '伊川县', NULL, '250003014', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013194814525441, '偃师市', NULL, '250003015', '250003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013194961326080, '平顶山市', NULL, '250004', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013194961326081, '新华区', NULL, '250004001', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013195179429889, '卫东区', NULL, '250004002', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013195330424833, '石龙区', NULL, '250004003', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013195473031169, '湛河区', NULL, '250004004', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013195628220417, '宝丰县', NULL, '250004005', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013195775021057, '叶县', NULL, '250004006', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013195921821697, '鲁山县', NULL, '250004007', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013196072816641, '郏县', NULL, '250004008', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013196223811585, '舞钢市', NULL, '250004009', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013196379000833, '汝州市', NULL, '250004010', '250004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013196534190080, '安阳市', NULL, '250005', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013196534190081, '文峰区', NULL, '250005001', '250005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013196756488193, '北关区', NULL, '250005002', '250005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013196907483137, '殷都区', NULL, '250005003', '250005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013197054283777, '龙安区', NULL, '250005004', '250005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013197205278721, '安阳县', NULL, '250005005', '250005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013197356273665, '汤阴县', NULL, '250005006', '250005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013197511462913, '滑县', NULL, '250005007', '250005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013197658263553, '内黄县', NULL, '250005008', '250005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013197800869889, '林州市', NULL, '250005009', '250005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013197947670528, '鹤壁市', NULL, '250006', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013197947670529, '鹤山区', NULL, '250006001', '250006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013198186745857, '山城区', NULL, '250006002', '250006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013198346129409, '淇滨区', NULL, '250006003', '250006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013198501318657, '浚县', NULL, '250006004', '250006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013198652313601, '淇县', NULL, '250006005', '250006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013198803308544, '新乡市', NULL, '250007', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013198803308545, '红旗区', NULL, '250007001', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013199033995265, '卫滨区', NULL, '250007002', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013199184990209, '凤泉区', NULL, '250007003', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013199327596545, '牧野区', NULL, '250007004', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013199470202881, '新乡县', NULL, '250007005', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013199621197825, '获嘉县', NULL, '250007006', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013199767998465, '原阳县', NULL, '250007007', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013199918993409, '延津县', NULL, '250007008', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013200061599745, '封丘县', NULL, '250007009', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013200208400385, '长垣县', NULL, '250007010', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013200355201025, '卫辉市', NULL, '250007011', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013200510390273, '辉县市', NULL, '250007012', '250007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013200661385216, '焦作市', NULL, '250008', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013200661385217, '解放区', NULL, '250008001', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013200883683329, '中站区', NULL, '250008002', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013201026289665, '马村区', NULL, '250008003', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013201168896001, '山阳区', NULL, '250008004', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013201319890945, '修武县', NULL, '250008005', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013201475080193, '博爱县', NULL, '250008006', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013201651240961, '武陟县', NULL, '250008007', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013201835790337, '温县', NULL, '250008008', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013201986785281, '沁阳市', NULL, '250008009', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013202125197313, '孟州市', NULL, '250008010', '250008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013202267803648, '濮阳市', NULL, '250009', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013202267803649, '华龙区', NULL, '250009001', '250009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013202515267585, '清丰县', NULL, '250009002', '250009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013202666262529, '南乐县', NULL, '250009003', '250009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013202817257473, '范县', NULL, '250009004', '250009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013202985029633, '台前县', NULL, '250009005', '250009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013203140218881, '濮阳县', NULL, '250009006', '250009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013203287019520, '许昌市', NULL, '250010', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013203287019521, '魏都区', NULL, '250010001', '250010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013203517706241, '建安区', NULL, '250010002', '250010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013203660312577, '鄢陵县', NULL, '250010003', '250010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013203815501825, '襄城县', NULL, '250010004', '250010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013203966496769, '禹州市', NULL, '250010005', '250010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013204117491713, '长葛市', NULL, '250010006', '250010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013204276875264, '漯河市', NULL, '250011', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013204276875265, '源汇区', NULL, '250011001', '250011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013204499173377, '郾城区', NULL, '250011002', '250011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013204654362625, '召陵区', NULL, '250011003', '250011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013204801163265, '舞阳县', NULL, '250011004', '250011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013204956352513, '临颍县', NULL, '250011005', '250011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013205103153152, '三门峡市', NULL, '250012', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013205103153153, '湖滨区', NULL, '250012001', '250012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013205333839873, '陕州区', NULL, '250012002', '250012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013205493223425, '渑池县', NULL, '250012003', '250012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013205635829761, '卢氏县', NULL, '250012004', '250012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013205786824705, '义马市', NULL, '250012005', '250012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013205942013953, '灵宝市', '灵宝市', '250012006', '250012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013206101397504, '南阳市', '南阳市', '250013', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013206101397505, '宛城区', '宛城区', '250013001', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013206323695617, '卧龙区', '卧龙区', '250013002', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013206470496257, '南召县', '南召县', '250013003', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013206617296897, '方城县', '方城县', '250013004', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013206768291841, '西峡县', '西峡县', '250013005', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013206919286785, '镇平县', '镇平县', '250013006', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013207078670336, '内乡县', '内乡县', '250013007', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013207233859585, '淅川县', '淅川县', '250013008', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013207389048833, '社旗县', '社旗县', '250013009', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013207535849473, '唐河县', '唐河县', '250013010', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013207682650113, '新野县', '新野县', '250013011', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013207837839361, '桐柏县', '桐柏县', '250013012', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013207993028609, '邓州市', '邓州市', '250013013', '250013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013208148217856, '商丘市', '商丘市', '250014', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013208148217857, '梁园区', '梁园区', '250014001', '250014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013208362127361, '睢阳区', '睢阳区', '250014002', '250014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013208513122305, '民权县', '民权县', '250014003', '250014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013208668311553, '睢县', '睢县', '250014004', '250014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013208823500801, '宁陵县', '宁陵县', '250014005', '250014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013208987078657, '柘城县', '柘城县', '250014006', '250014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013209171628033, '虞城县', '虞城县', '250014007', '250014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013209326817281, '夏邑县', '夏邑县', '250014008', '250014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013209482006529, '永城市', '永城市', '250014009', '250014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013209633001472, '信阳市', '信阳市', '250015', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013209633001473, '浉河区', '浉河区', '250015001', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013209859493889, '平桥区', '平桥区', '250015002', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013210014683137, '罗山县', '罗山县', '250015003', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013210165678081, '光山县', '光山县', '250015004', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013210308284417, '新县', '新县', '250015005', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013210463473665, '商城县', '商城县', '250015006', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013210610274305, '固始县', '固始县', '250015007', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013210769657857, '潢川县', '潢川县', '250015008', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013210912264193, '淮滨县', '淮滨县', '250015009', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013211071647745, '息县', '息县', '250015010', '250015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013211222642688, '周口市', '周口市', '250016', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013211222642689, '川汇区', '川汇区', '250016001', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013211470106625, '项城市', '项城市', '250016002', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013211625295873, '扶沟县', NULL, '250016003', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013211776290817, '西华县', NULL, '250016004', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013211918897153, '商水县', NULL, '250016005', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013212069892097, '太康县', NULL, '250016006', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013212220887041, '鹿邑县', NULL, '250016007', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013212371881985, '郸城县', NULL, '250016008', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013212531265537, '淮阳县', NULL, '250016009', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013212686454785, '沈丘县', NULL, '250016010', '250016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013212837449728, '驻马店地区', '驻马店地区', '250017', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013212837449729, '驿城区', NULL, '250017001', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013213068136449, '确山县', NULL, '250017002', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013213231714305, '泌阳县', NULL, '250017003', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013213382709249, '遂平县', NULL, '250017004', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013213529509889, '西平县', NULL, '250017005', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013213680504833, '上蔡县', NULL, '250017006', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013213831499777, '汝南县', NULL, '250017007', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013213974106113, '平舆县', NULL, '250017008', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013214120906753, '新蔡县', NULL, '250017009', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013214280290305, '正阳县', NULL, '250017010', '250017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013214435479552, '省直辖行政单位', '省直辖行政单位', '250018', '250', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013214435479553, '济源市', NULL, '250018001', '250018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013214657777664, '湖北省', '湖北', '260', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013214766829568, '武汉市', '武汉市', '260001', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013214766829569, '江岸区', NULL, '260001001', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013214984933377, '江汉区', NULL, '260001002', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013215131734017, '硚口区', NULL, '260001003', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013215282728961, '汉阳区', NULL, '260001004', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013215437918209, '武昌区', NULL, '260001005', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013215584718849, '青山区', NULL, '260001006', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013215744102401, '洪山区', NULL, '260001007', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013215895097345, '东西湖区', NULL, '260001008', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013216062869505, '汉南区', NULL, '260001009', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013216218058753, '蔡甸区', NULL, '260001010', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013216390025217, '江夏区', NULL, '260001011', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013216561991681, '黄陂区', NULL, '260001012', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013216717180929, '新洲区', NULL, '260001013', '260001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013216868175872, '黄石市', '黄石市', '260002', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013216868175873, '黄石港区', NULL, '260002001', '260002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013217098862593, '西塞山区', NULL, '260002002', '260002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013217237274625, '下陆区', NULL, '260002003', '260002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013217384075265, '铁山区', NULL, '260002004', '260002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013217526681601, '阳新县', NULL, '260002005', '260002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013217677676545, '大冶市', NULL, '260002006', '260002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013217824477184, '十堰市', '十堰市', '260003', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013217824477185, '茅箭区', NULL, '260003001', '260003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013218067746817, '张湾区', NULL, '260003002', '260003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013218214547457, '郧阳区', NULL, '260003003', '260003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013218361348097, '郧西县', NULL, '260003004', '260003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013218508148737, '竹山县', NULL, '260003005', '260003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013218663337985, '竹溪县', NULL, '260003006', '260003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013218814332929, '房县', NULL, '260003007', '260003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013218965327873, '丹江口市', NULL, '260003008', '260003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013219124711424, '宜昌市', '宜昌市', '260004', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013219124711425, '西陵区', NULL, '260004001', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013219355398145, '伍家岗区', NULL, '260004002', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013219510587393, '点军区', NULL, '260004003', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013219653193729, '猇亭区', NULL, '260004004', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013219808382977, '夷陵区', NULL, '260004005', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013219950989313, '远安县', NULL, '260004006', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013220106178561, '兴山县', NULL, '260004007', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013220265562113, '秭归县', NULL, '260004008', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013220420751361, '长阳土家族自治县', NULL, '260004009', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013220584329217, '五峰土家族自治县', NULL, '260004010', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013220735324161, '宜都市', NULL, '260004011', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013220882124801, '当阳市', NULL, '260004012', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013221024731137, '枝江市', NULL, '260004013', '260004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013221175726080, '襄阳市', '襄阳市', '260005', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013221175726081, '襄城区', NULL, '260005001', '260005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013221410607105, '樊城区', NULL, '260005002', '260005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013221569990657, '襄州区', NULL, '260005003', '260005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013221720985601, '南漳县', NULL, '260005004', '260005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013221871980545, '谷城县', NULL, '260005005', '260005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013222010392577, '保康县', NULL, '260005006', '260005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013222165581825, '老河口市', NULL, '260005007', '260005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013222316576769, '枣阳市', NULL, '260005008', '260005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013222467571713, '宜城市', NULL, '260005009', '260005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013222622760960, '鄂州市', '鄂州市', '260006', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013222622760961, '梁子湖区', NULL, '260006001', '260006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013222853447681, '华容区', NULL, '260006002', '260006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013223004442625, '鄂城区', NULL, '260006003', '260006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013223147048960, '荆门市', '荆门市', '260007', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013223147048961, '东宝区', NULL, '260007001', '260007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013223386124289, '掇刀区', NULL, '260007002', '260007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013223537119233, '京山县', NULL, '260007003', '260007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013223688114177, '沙洋县', NULL, '260007004', '260007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013223847497729, '钟祥市', NULL, '260007005', '260007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013224011075584, '孝感市', '孝感市', '260008', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013224011075585, '孝南区', NULL, '260008001', '260008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013224241762305, '孝昌县', NULL, '260008002', '260008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013224396951553, '大悟县', NULL, '260008003', '260008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013224552140801, '云梦县', NULL, '260008004', '260008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013224698941441, '应城市', NULL, '260008005', '260008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013224854130689, '安陆市', NULL, '260008006', '260008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013225000931329, '汉川市', NULL, '260008007', '260008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013225147731968, '荆州市', '荆州市', '260009', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013225147731969, '沙市区', NULL, '260009001', '260009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013225378418689, '荆州区', NULL, '260009002', '260009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013225516830721, '公安县', NULL, '260009003', '260009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013225684602881, '监利县', NULL, '260009004', '260009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013225839792129, '江陵县', NULL, '260009005', '260009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013225982398465, '石首市', NULL, '260009006', '260009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013226125004801, '洪湖市', NULL, '260009007', '260009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013226275999745, '松滋市', NULL, '260009008', '260009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013226426994688, '黄冈市', '黄冈市', '260010', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013226426994689, '黄州区', NULL, '260010001', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013226661875713, '团风县', NULL, '260010002', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013226812870657, '红安县', NULL, '260010003', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013226968059905, '罗田县', NULL, '260010004', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013227131637761, '英山县', NULL, '260010005', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013227286827009, '浠水县', NULL, '260010006', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013227433627649, '蕲春县', NULL, '260010007', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013227580428289, '黄梅县', NULL, '260010008', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013227731423233, '麻城市', NULL, '260010009', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013227886612481, '武穴市', NULL, '260010010', '260010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013228037607424, '咸宁市', '咸宁市', '260011', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013228037607425, '咸安区', NULL, '260011001', '260011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013228268294145, '嘉鱼县', NULL, '260011002', '260011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013228427677697, '通城县', NULL, '260011003', '260011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013228578672641, '崇阳县', NULL, '260011004', '260011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013228729667585, '通山县', NULL, '260011005', '260011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013228876468225, '赤壁市', NULL, '260011006', '260011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013229019074560, '恩施土家族苗族自治州', '恩施土家族苗族自治州', '260012', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013229019074561, '恩施市', NULL, '260012001', '260012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013229245566977, '利川市', NULL, '260012002', '260012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013229396561921, '建始县', NULL, '260012003', '260012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013229543362561, '巴东县', NULL, '260012004', '260012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013229698551809, '宣恩县', NULL, '260012005', '260012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013229849546753, '咸丰县', NULL, '260012006', '260012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013229996347393, '来凤县', NULL, '260012007', '260012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013230138953729, '鹤峰县', NULL, '260012008', '260012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013230294142976, '随州市', '随州市', '260013', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013230294142977, '曾都区', NULL, '260013001', '260013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013230529024001, '广水市', NULL, '260013002', '260013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013230675824641, '随县', NULL, '260013003', '260013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013230826819584, '省直辖行政单位', '省直辖行政单位', '260014', '260', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013230826819585, '仙桃市', NULL, '260014001', '260014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013231049117697, '潜江市', NULL, '260014002', '260014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013231204306945, '天门市', NULL, '260014003', '260014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013231359496193, '神农架林区', NULL, '260014004', '260014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013231510491136, '湖南省', '湖南', '270', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013231619543040, '长沙市', '长沙市', '270001', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013231619543041, '芙蓉区', NULL, '270001001', '270001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013231841841153, '天心区', NULL, '270001002', '270001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013231997030401, '岳麓区', NULL, '270001003', '270001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013232139636737, '开福区', NULL, '270001004', '270001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013232299020289, '雨花区', NULL, '270001005', '270001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013232441626625, '望城区', NULL, '270001006', '270001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013232588427265, '长沙县', NULL, '270001007', '270001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013232735227905, '宁乡县', NULL, '270001008', '270001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013232882028545, '浏阳市', NULL, '270001009', '270001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013233045606400, '株洲市', '株洲市', '270002', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013233045606401, '荷塘区', NULL, '270002001', '270002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013233280487425, '芦淞区', NULL, '270002002', '270002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013233439870977, '石峰区', NULL, '270002003', '270002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013233590865921, '天元区', NULL, '270002004', '270002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013233737666561, '株洲县', NULL, '270002005', '270002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013233876078593, '攸县', NULL, '270002006', '270002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013234031267841, '茶陵县', NULL, '270002007', '270002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013234182262785, '炎陵县', NULL, '270002008', '270002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013234324869121, '醴陵市', NULL, '270002009', '270002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013234484252672, '湘潭市', '湘潭市', '270003', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013234484252673, '雨湖区', NULL, '270003001', '270003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013234719133697, '岳塘区', NULL, '270003002', '270003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013234874322945, '湘潭县', NULL, '270003003', '270003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013235029512193, '湘乡市', NULL, '270003004', '270003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013235176312833, '韶山市', NULL, '270003005', '270003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013235318919168, '衡阳市', '衡阳市', '270004', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013235318919169, '珠晖区', NULL, '270004001', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013235537022977, '雁峰区', NULL, '270004002', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013235692212225, '石鼓区', NULL, '270004003', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013235843207169, '蒸湘区', NULL, '270004004', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013235994202113, '南岳区', NULL, '270004005', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013236149391361, '衡阳县', NULL, '270004006', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013236296192001, '衡南县', NULL, '270004007', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013236455575553, '衡山县', NULL, '270004008', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013236606570497, '衡东县', NULL, '270004009', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013236761759745, '祁东县', NULL, '270004010', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013236912754689, '耒阳市', NULL, '270004011', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013237067943937, '常宁市', NULL, '270004012', '270004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013237206355968, '邵阳市', '邵阳市', '270005', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013237206355969, '双清区', NULL, '270005001', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013237437042689, '大祥区', NULL, '270005002', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013237583843329, '北塔区', NULL, '270005003', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013237734838273, '邵东县', NULL, '270005004', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013237890027521, '新邵县', NULL, '270005005', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013238049411073, '邵阳县', NULL, '270005006', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013238229766145, '隆回县', NULL, '270005007', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013238389149697, '洞口县', NULL, '270005008', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013238540144641, '绥宁县', NULL, '270005009', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013238691139585, '新宁县', NULL, '270005010', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013238833745921, '城步苗族自治县', NULL, '270005011', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013238980546561, '武冈市', NULL, '270005012', '270005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013239123152896, '岳阳市', '岳阳市', '270006', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013239123152897, '岳阳楼区', NULL, '270006001', '270006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013239332868097, '云溪区', NULL, '270006002', '270006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013239488057344, '君山区', NULL, '270006003', '270006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013239634857985, '岳阳县', NULL, '270006004', '270006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013239785852929, '华容县', NULL, '270006005', '270006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013239932653569, '湘阴县', NULL, '270006006', '270006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013240079454209, '平江县', NULL, '270006007', '270006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013240226254849, '汨罗市', NULL, '270006008', '270006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013240377249793, '临湘市', NULL, '270006009', '270006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013240528244736, '常德市', '常德市', '270007', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013240528244737, '武陵区', NULL, '270007001', '270007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013240754737153, '鼎城区', NULL, '270007002', '270007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013240909926401, '安乡县', NULL, '270007003', '270007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013241090281473, '汉寿县', NULL, '270007004', '270007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013241245470721, '澧县', NULL, '270007005', '270007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013241413242881, '临澧县', NULL, '270007006', '270007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013241564237825, '桃源县', NULL, '270007007', '270007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013241723621377, '石门县', NULL, '270007008', '270007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013241883004929, '津市市', NULL, '270007009', '270007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013242038194176, '张家界市', '张家界市', '270008', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013242038194177, '永定区', NULL, '270008001', '270008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013242273075201, '武陵源区', NULL, '270008002', '270008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013242419875841, '慈利县', NULL, '270008003', '270008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013242570870785, '桑植县', NULL, '270008004', '270008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013242713477120, '益阳市', '益阳市', '270009', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013242713477121, '资阳区', NULL, '270009001', '270009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013242939969537, '赫山区', NULL, '270009002', '270009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013243090964481, '南县', NULL, '270009003', '270009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013243233570817, '桃江县', NULL, '270009004', '270009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013243380371457, '安化县', NULL, '270009005', '270009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013243527172097, '沅江市', NULL, '270009006', '270009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013243673972736, '郴州市', '郴州市', '270010', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013243673972737, '北湖区', NULL, '270010001', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013243892076545, '苏仙区', NULL, '270010002', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013244047265793, '桂阳县', NULL, '270010003', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013244185677825, '宜章县', NULL, '270010004', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013244328284161, '永兴县', NULL, '270010005', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013244479279105, '嘉禾县', NULL, '270010006', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013244626079745, '临武县', NULL, '270010007', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013244772880385, '汝城县', NULL, '270010008', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013244919681025, '桂东县', NULL, '270010009', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013245070675969, '安仁县', NULL, '270010010', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013245217476609, '资兴市', NULL, '270010011', '270010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013245368471552, '永州市', '永州市', '270011', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013245368471553, '零陵区', NULL, '270011001', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013245594963969, '冷水滩区', NULL, '270011002', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013245758541825, '祁阳县', NULL, '270011003', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013245913731073, '东安县', NULL, '270011004', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013246056337409, '双牌县', NULL, '270011005', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013246211526657, '道县', NULL, '270011006', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013246362521601, '江永县', NULL, '270011007', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013246513516545, '宁远县', NULL, '270011008', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013246677094401, '蓝山县', NULL, '270011009', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013246828089345, '新田县', NULL, '270011010', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013246979084289, '江华瑶族自治县', NULL, '270011011', '270011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013247134273536, '怀化市', '怀化市', '270012', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013247134273537, '鹤城区', NULL, '270012001', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013247364960257, '中方县', NULL, '270012002', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013247520149505, '沅陵县', NULL, '270012003', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013247679533057, '辰溪县', NULL, '270012004', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013247834722305, '溆浦县', NULL, '270012005', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013247985717249, '会同县', NULL, '270012006', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013248140906497, '麻阳苗族自治县', NULL, '270012007', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013248283512833, '新晃侗族自治县', NULL, '270012008', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013248438702081, '芷江侗族自治县', NULL, '270012009', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013248589697025, '靖州苗族侗族自治县', NULL, '270012010', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013248736497665, '通道侗族自治县', NULL, '270012011', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013248887492609, '洪江市', NULL, '270012012', '270012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013249034293248, '娄底地区', '娄底地区', '270013', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013249034293249, '娄星区', NULL, '270013001', '270013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013249264979969, '冷水江市', NULL, '270013002', '270013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013249415974913, '涟源市', NULL, '270013003', '270013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013249554386945, '双峰县', NULL, '270013004', '270013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013249705381889, '新化县', NULL, '270013005', '270013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013249856376832, '湘西土家族苗族自治州', '湘西土家族苗族自治州', '270014', '270', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013249856376833, '吉首市', NULL, '270014001', '270014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013250087063553, '泸溪县', NULL, '270014002', '270014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013250238058497, '凤凰县', NULL, '270014003', '270014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013250380664833, '花垣县', NULL, '270014004', '270014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013250527465473, '保靖县', NULL, '270014005', '270014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013250678460417, '古丈县', NULL, '270014006', '270014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013250829455361, '永顺县', NULL, '270014007', '270014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013250984644609, '龙山县', NULL, '270014008', '270014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013251135639552, '广东省', '广东', '280', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013251253080064, '广州市', '广州市', '280001', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013251253080065, '荔湾区', NULL, '280001001', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013251483766785, '越秀区', NULL, '280001002', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013251638956033, '海珠区', NULL, '280001003', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013251789950977, '天河区', NULL, '280001004', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013251940945921, '白云区', NULL, '280001005', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013252096135169, '黄埔区', NULL, '280001006', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013252234547201, '番禺区', NULL, '280001007', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013252381347841, '花都区', NULL, '280001008', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013252532342785, '南沙区', NULL, '280001009', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013252683337729, '增城区', NULL, '280001010', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013252825944065, '从化区', NULL, '280001011', '280001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013252972744704, '韶关市', '韶关市', '280002', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013252972744705, '武江区', NULL, '280002001', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013253190848513, '浈江区', NULL, '280002002', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013253341843457, '曲江区', NULL, '280002003', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013253484449793, '始兴县', NULL, '280002004', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013253635444737, '仁化县', NULL, '280002005', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013253773856769, '翁源县', NULL, '280002006', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013253920657409, '乳源瑶族自治县', NULL, '280002007', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013254067458049, '新丰县', NULL, '280002008', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013254205870081, '乐昌市', NULL, '280002009', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013254365253633, '南雄市', NULL, '280002010', '280002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013254507859968, '深圳市', '深圳市', '280003', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013254507859969, '罗湖区', NULL, '280003001', '280003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013254725963777, '福田区', NULL, '280003002', '280003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013254881153025, '南山区', NULL, '280003003', '280003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013255023759361, '宝安区', NULL, '280003004', '280003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013255174754305, '龙岗区', NULL, '280003005', '280003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013255321554945, '龙华区', NULL, '280003006', '280003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013255480938497, '坪山区', NULL, '280003007', '280003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013255631933441, '盐田区', NULL, '280003008', '280003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013255778734080, '珠海市', '珠海市', '280004', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013255778734081, '香洲区', NULL, '280004001', '280004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013256022003713, '斗门区', NULL, '280004002', '280004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013256172998657, '金湾区', NULL, '280004003', '280004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013256332382208, '汕头市', '汕头市', '280005', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013256332382209, '濠江区', NULL, '280005001', '280005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013256563068929, '龙湖区', NULL, '280005002', '280005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013256718258177, '金平区', NULL, '280005003', '280005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013256873447425, '潮南区', NULL, '280005004', '280005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013257024442369, '澄海区', NULL, '280005005', '280005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013257175437313, '潮阳区', NULL, '280005006', '280005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013257330626561, '南澳县', NULL, '280005007', '280005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013257477427200, '佛山市', '佛山市', '280006', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013257477427201, '禅城区', NULL, '280006001', '280006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013257708113921, '顺德区', NULL, '280006002', '280006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013257867497473, '南海区', NULL, '280006003', '280006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013258022686721, '三水区', NULL, '280006004', '280006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013258177875969, '高明区', NULL, '280006005', '280006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013258333065216, '江门市', '江门市', '280007', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013258333065217, '蓬江区', NULL, '280007001', '280007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013258559557633, '江海区', NULL, '280007002', '280007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013258714746881, '新会区', NULL, '280007003', '280007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013258861547521, '台山市', NULL, '280007004', '280007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013259016736769, '开平市', NULL, '280007005', '280007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013259176120321, '鹤山市', NULL, '280007006', '280007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013259322920961, '恩平市', NULL, '280007007', '280007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013259473915904, '湛江市', '湛江市', '280008', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013259473915905, '赤坎区', NULL, '280008001', '280008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013259708796929, '霞山区', NULL, '280008002', '280008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013259863986177, '坡头区', NULL, '280008003', '280008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013260014981121, '麻章区', NULL, '280008004', '280008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013260170170369, '遂溪县', NULL, '280008005', '280008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013260321165313, '徐闻县', NULL, '280008006', '280008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013260472160257, '廉江市', NULL, '280008007', '280008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013260623155201, '雷州市', NULL, '280008008', '280008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013260778344449, '吴川市', NULL, '280008009', '280008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013260916756480, '茂名市', '茂名市', '280009', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013260916756481, '茂南区', NULL, '280009001', '280009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013261143248897, '电白区', NULL, '280009002', '280009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013261277466625, '高州市', NULL, '280009003', '280009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013261420072961, '化州市', NULL, '280009004', '280009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013261566873601, '信宜市', NULL, '280009005', '280009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013261701091328, '肇庆市', '肇庆市', '280010', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013261701091329, '端州区', NULL, '280010001', '280010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013261931778049, '鼎湖区', NULL, '280010002', '280010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013262074384385, '高要区', NULL, '280010003', '280010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013262216990721, '广宁县', NULL, '280010004', '280010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013262367985665, '怀集县', NULL, '280010005', '280010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013262510592001, '封开县', NULL, '280010006', '280010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013262657392641, '德庆县', NULL, '280010007', '280010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013262804193281, '四会市', NULL, '280010008', '280010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013262946799616, '惠州市', '惠州市', '280011', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013262946799617, '惠城区', NULL, '280011001', '280011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013263169097729, '惠阳区', NULL, '280011002', '280011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013263311704065, '博罗县', NULL, '280011003', '280011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013263454310401, '惠东县', NULL, '280011004', '280011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013263596916737, '龙门县', NULL, '280011005', '280011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013263735328768, '梅州市', '梅州市', '280012', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013263735328769, '梅江区', NULL, '280012001', '280012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013263961821185, '梅县区', NULL, '280012002', '280012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013264112816129, '大埔县', NULL, '280012003', '280012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013264259616769, '丰顺县', NULL, '280012004', '280012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013264410611713, '五华县', NULL, '280012005', '280012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013264553218049, '平远县', NULL, '280012006', '280012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013264700018689, '蕉岭县', NULL, '280012007', '280012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013264842625025, '兴宁市', NULL, '280012008', '280012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013264976842752, '汕尾市', '汕尾市', '280013', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013264976842753, '城区', NULL, '280013001', '280013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013265199140865, '海丰县', NULL, '280013002', '280013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013265341747201, '陆河县', NULL, '280013003', '280013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013265492742145, '陆丰市', NULL, '280013004', '280013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013265631154176, '河源市', '河源市', '280014', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013265631154177, '源城区', NULL, '280014001', '280014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013265849257985, '紫金县', NULL, '280014002', '280014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013265996058625, '龙川县', NULL, '280014003', '280014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013266134470657, '连平县', NULL, '280014004', '280014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013266272882689, '和平县', NULL, '280014005', '280014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013266419683329, '东源县', NULL, '280014006', '280014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013266574872576, '阳江市', '阳江市', '280015', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013266574872577, '江城区', NULL, '280015001', '280015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013266792976385, '阳东区', NULL, '280015002', '280015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013266939777025, '阳西县', NULL, '280015003', '280015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013267090771969, '阳春市', NULL, '280015004', '280015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013267233378304, '清远市', '清远市', '280016', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013267233378305, '清城区', NULL, '280016001', '280016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013267451482113, '清新区', NULL, '280016002', '280016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013267598282753, '佛冈县', NULL, '280016003', '280016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013267740889089, '阳山县', NULL, '280016004', '280016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013267887689729, '连山壮族瑶族自治县', NULL, '280016005', '280016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013268030296065, '连南瑶族自治县', NULL, '280016006', '280016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013268177096705, '英德市', NULL, '280016007', '280016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013268319703041, '连州市', NULL, '280016008', '280016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013268470697984, '东莞市', '东莞市', '280017', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013268470697985, '东莞市', NULL, '280017001', '280017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013268697190400, '中山市', '中山市', '280018', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013268697190401, '中山市', NULL, '280018001', '280018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013268927877120, '潮州市', '潮州市', '280019', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013268927877121, '湘桥区', NULL, '280019001', '280019', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013269158563841, '潮安区', NULL, '280019002', '280019', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013269301170177, '饶平县', NULL, '280019003', '280019', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013269452165120, '揭阳市', '揭阳市', '280020', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013269452165121, '榕城区', NULL, '280020001', '280020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013269674463233, '揭东区', NULL, '280020002', '280020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013269821263873, '揭西县', NULL, '280020003', '280020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013269972258817, '惠来县', NULL, '280020004', '280020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013270119059457, '普宁市', NULL, '280020005', '280020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013270257471488, '云浮市', '云浮市', '280021', '280', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013270257471489, '云城区', NULL, '280021001', '280021', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013270483963905, '云安区', NULL, '280021002', '280021', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013270630764545, '新兴县', NULL, '280021003', '280021', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013270777565185, '郁南县', NULL, '280021004', '280021', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013270928560129, '罗定市', NULL, '280021005', '280021', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013271134081024, '广西', '广西', '290', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013271247327232, '南宁市', '南宁市', '290001', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013271247327233, '兴宁区', NULL, '290001001', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013271486402561, '青秀区', NULL, '290001002', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013271633203201, '西乡塘区', NULL, '290001003', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013271788392449, '江南区', NULL, '290001004', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013271935193089, '良庆区', NULL, '290001005', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013272086188033, '邕宁区', NULL, '290001006', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013272237182977, '武鸣区', NULL, '290001007', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013272388177921, '隆安县', NULL, '290001008', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013272543367169, '马山县', NULL, '290001009', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013272694362113, '上林县', NULL, '290001010', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013272841162753, '宾阳县', NULL, '290001011', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013273000546305, '横县', NULL, '290001012', '290001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013273147346944, '柳州市', '柳州市', '290002', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013273147346945, '城中区', NULL, '290002001', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013273365450753, '鱼峰区', NULL, '290002002', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013273524834305, '柳南区', NULL, '290002003', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013273680023553, '柳北区', NULL, '290002004', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013273826824193, '柳江县', NULL, '290002005', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013273977819137, '柳城县', NULL, '290002006', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013274133008385, '鹿寨县', NULL, '290002007', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013274284003329, '融安县', NULL, '290002008', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013274430803969, '融水苗族自治县', NULL, '290002009', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013274577604609, '三江侗族自治县', NULL, '290002010', '290002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013274732793856, '桂林市', '桂林市', '290003', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013274732793857, '秀峰区', NULL, '290003001', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013274963480577, '叠彩区', NULL, '290003002', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013275106086913, '象山区', NULL, '290003003', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013275252887553, '七星区', NULL, '290003004', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013275395493889, '雁山区', NULL, '290003005', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013275542294529, '临桂区', NULL, '290003006', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013275697483777, '阳朔县', NULL, '290003007', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013275835895809, '灵川县', NULL, '290003008', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013275982696449, '全州县', NULL, '290003009', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013276133691393, '兴安县', NULL, '290003010', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013276284686337, '永福县', NULL, '290003011', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013276427292673, '灌阳县', NULL, '290003012', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013276574093313, '龙胜各族自治县', NULL, '290003013', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013276741865473, '资源县', NULL, '290003014', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013276901249025, '平乐县', NULL, '290003015', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013277056438273, '荔蒲县', NULL, '290003016', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013277211627521, '恭城瑶族自治县', NULL, '290003017', '290003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013277362622464, '梧州市', '梧州市', '290004', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013277362622465, '万秀区', NULL, '290004001', '290004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013277593309185, '长洲区', NULL, '290004002', '290004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013277735915521, '龙圩区', NULL, '290004003', '290004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013277886910465, '苍梧县', NULL, '290004004', '290004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013278042099713, '藤县', NULL, '290004005', '290004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013278184706049, '蒙山县', NULL, '290004006', '290004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013278344089601, '岑溪市', NULL, '290004007', '290004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013278499278848, '北海市', '北海市', '290005', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013278499278849, '海城区', NULL, '290005001', '290005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013278729965569, '银海区', NULL, '290005002', '290005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013278885154817, '铁山港区', NULL, '290005003', '290005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013279031955457, '合浦县', NULL, '290005004', '290005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013279178756096, '防城港市', '防城港市', '290006', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013279178756097, '港口区', NULL, '290006001', '290006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013279417831425, '防城区', NULL, '290006002', '290006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013279564632065, '上思县', NULL, '290006003', '290006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013279724015617, '东兴市', NULL, '290006004', '290006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013279870816256, '钦州市', '钦州市', '290007', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013279870816257, '钦南区', NULL, '290007001', '290007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013280101502977, '钦北区', NULL, '290007002', '290007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013280248303617, '浦北县', NULL, '290007003', '290007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013280399298561, '灵山县', NULL, '290007004', '290007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013280546099200, '贵港市', '贵港市', '290008', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013280546099201, '港北区', NULL, '290008001', '290008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013280768397313, '港南区', NULL, '290008002', '290008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013280923586561, '覃塘区', NULL, '290008003', '290008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013281074581505, '平南县', NULL, '290008004', '290008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013281229770753, '桂平市', NULL, '290008005', '290008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013281380765696, '玉林市', '玉林市', '290009', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013281380765697, '玉州区', NULL, '290009001', '290009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013281607258113, '福绵区', NULL, '290009002', '290009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013281754058753, '容县', NULL, '290009003', '290009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013281905053697, '陆川县', NULL, '290009004', '290009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013282056048641, '博白县', NULL, '290009005', '290009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013282207043585, '兴业县', NULL, '290009006', '290009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013282353844225, '北流市', NULL, '290009007', '290009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013282509033472, '崇左市', '崇左市', '290010', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013282509033473, '江州区', NULL, '290010001', '290010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013282735525889, '凭祥市', NULL, '290010002', '290010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013282894909441, '扶绥县', NULL, '290010003', '290010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013283045904385, '宁明县', NULL, '290010004', '290010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013283196899329, '龙州县', NULL, '290010005', '290010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013283352088577, '大新县', NULL, '290010006', '290010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013283503083521, '天等县', NULL, '290010007', '290010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013283654078464, '来宾市', NULL, '290011', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013283654078465, '兴宾区', NULL, '290011001', '290011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013283884765185, '合山市', NULL, '290011002', '290011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013284039954433, '忻城县', NULL, '290011003', '290011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013284195143681, '象州县', NULL, '290011004', '290011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013284350332929, '武宣县', NULL, '290011005', '290011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013284501327873, '金秀瑶族自治县', NULL, '290011006', '290011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013284660711424, '贺州市', NULL, '290012', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013284660711425, '八步区', NULL, '290012001', '290012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013284887203841, '平桂区', NULL, '290012002', '290012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013285038198785, '昭平县', NULL, '290012003', '290012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013285197582337, '钟山县', NULL, '290012004', '290012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013285352771585, '　富川瑶族自治县', NULL, '290012005', '290012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013285503766528, '百色市', NULL, '290013', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013285503766529, '右江区', NULL, '290013001', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013285730258945, '靖西市', NULL, '290013002', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013285885448193, '田阳县', NULL, '290013003', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013286040637441, '田东县', NULL, '290013004', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013286191632385, '平果县', NULL, '290013005', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013286338433025, '德保县', NULL, '290013006', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013286497816577, '那坡县', NULL, '290013007', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013286636228609, '凌云县', NULL, '290013008', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013286799806465, '乐业县', NULL, '290013009', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013286938218497, '田林县', NULL, '290013010', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013287085019137, '隆林各族自治县', NULL, '290013011', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013287244402689, '西林县', NULL, '290013012', '290013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013287387009024, '河池市', NULL, '290014', '290', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013287387009025, '金城江区', NULL, '290014001', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013287617695745, '宜州区', NULL, '290014002', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013287760302081, '罗城仫佬族自治县', NULL, '290014003', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013287911297025, '环江毛南族自治县', NULL, '290014004', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013288062291969, '南丹县', NULL, '290014005', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013288204898305, '天峨县', NULL, '290014006', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013288343310337, '凤山县', NULL, '290014007', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013288490110977, '东兰县', NULL, '290014008', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013288628523009, '巴马瑶族自治县', NULL, '290014009', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013288766935041, '都安瑶族自治县', NULL, '290014010', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013288922124289, '大化瑶族自治县', NULL, '290014011', '290014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013289060536320, '海南省', '海南', '300', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013289177976832, '省直辖县级行政单位', NULL, '300001', '300', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013289177976833, '琼海市', NULL, '300001001', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013289391886337, '五指山市', NULL, '300001002', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013289534492673, '文昌市', NULL, '300001003', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013289681293313, '万宁市', NULL, '300001004', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013289823899649, '东方市', NULL, '300001005', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013289966505985, '定安县', NULL, '300001006', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013290100723713, '屯昌县', NULL, '300001007', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013290234941441, '澄迈县', NULL, '300001008', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013290381742081, '临高县', NULL, '300001009', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013290528542721, '白沙黎族自治县', NULL, '300001010', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013290683731969, '昌江黎族自治县', NULL, '300001011', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013290826338305, '乐东黎族自治县', NULL, '300001012', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013290973138945, '陵水黎族自治县', NULL, '300001013', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013291124133889, '保亭黎族苗族自治县', NULL, '300001014', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013291262545921, '琼中黎族苗族自治县', NULL, '300001015', '300001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013291409346560, '海口市', NULL, '300002', '300', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013291409346561, '龙华区', NULL, '300002001', '300002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013291644227585, '秀英区', NULL, '300002002', '300002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013291778445313, '琼山区', NULL, '300002003', '300002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013291933634561, '美兰区', NULL, '300002004', '300002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013292080435200, '三亚市', NULL, '300003', '300', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013292080435201, '吉阳区', NULL, '300003001', '300003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013292298539009, '崖州区', NULL, '300003002', '300003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013292449533953, '天涯区', NULL, '300003003', '300003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013292596334593, '海棠区', NULL, '300003004', '300003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013292747329536, '儋州市', NULL, '300004', '300', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013292747329537, '儋州市', NULL, '300004001', '300004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013292969627648, '三沙市', NULL, '300005', '300', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013292969627649, '三沙市', NULL, '300005001', '300005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013293196120064, '重庆市', '重庆', '310', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013293309366272, '重庆市', NULL, '310001', '310', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013293309366273, '万州区', NULL, '310001001', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013293523275777, '涪陵区', NULL, '310001002', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013293670076417, '渝中区', NULL, '310001003', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013293808488449, '大渡口区', NULL, '310001004', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013293955289089, '江北区', NULL, '310001005', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013294102089729, '沙坪坝区', NULL, '310001006', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013294248890369, '九龙坡区', NULL, '310001007', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013294387302401, '南岸区', NULL, '310001008', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013294529908737, '北碚区', NULL, '310001009', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013294668320769, '綦江区', NULL, '310001010', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013294815121409, '大足区', NULL, '310001011', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013294953533441, '渝北区', NULL, '310001012', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013295100334081, '江津区', NULL, '310001013', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013295247134721, '合川区', NULL, '310001014', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013295393935361, '巴南区', NULL, '310001015', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013295536541697, '长寿区', NULL, '310001016', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013295670759425, '潼南区', NULL, '310001017', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013295817560065, '铜梁区', NULL, '310001018', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013295964360705, '璧山区', NULL, '310001019', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013296115355649, '荣昌区', NULL, '310001020', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013296262156289, '黔江区', NULL, '310001021', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013296404762625, '永川区', NULL, '310001022', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013296580923393, '南川区', NULL, '310001023', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013296723529729, '开州区', NULL, '310001024', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013296870330369, '梁平区', NULL, '310001025', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013297017131009, '武隆区', NULL, '310001026', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013297163931649, '丰都县', NULL, '310001027', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013297306537985, '垫江县', NULL, '310001028', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013297444950017, '城口县', NULL, '310001029', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013297591750657, '忠县', NULL, '310001030', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013297734356993, '云阳县', NULL, '310001031', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013297881157633, '奉节县', NULL, '310001032', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013298023763969, '巫山县', NULL, '310001033', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013298162176001, '巫溪县', NULL, '310001034', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013298308976641, '石柱土家族自治县', NULL, '310001035', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013298464165889, '秀山土家族苗族自治县', NULL, '310001036', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013298610966529, '酉阳土家族苗族自治县', NULL, '310001037', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013298749378561, '彭水苗族土家族自治县', NULL, '310001038', '310001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013298883596288, '四川省', '四川', '320', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013298992648192, '成都市', NULL, '320001', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013298992648193, '锦江区', NULL, '320001001', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013299210752001, '青羊区', NULL, '320001002', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013299357552641, '金牛区', NULL, '320001003', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013299500158977, '武侯区', NULL, '320001004', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013299638571009, '成华区', NULL, '320001005', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013299781177345, '龙泉驿区', NULL, '320001006', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013299923783681, '青白江区', NULL, '320001007', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013300066390017, '温江区', NULL, '320001008', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013300217384961, '新都区', NULL, '320001009', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013300355796993, '双流区', NULL, '320001010', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013300506791937, '郫都区', NULL, '320001011', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013300649398273, '金堂县', NULL, '320001012', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013300787810305, '大邑县', NULL, '320001013', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013300930416641, '蒲江县', NULL, '320001014', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013301068828673, '新津县', NULL, '320001015', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013301211435009, '都江堰市', NULL, '320001016', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013301354041345, '彭州市', NULL, '320001017', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013301492453377, '邛崃市', NULL, '320001018', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013301635059713, '崇州市', NULL, '320001019', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013301781860353, '简阳市', NULL, '320001020', '320001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013301924466688, '自贡市', NULL, '320002', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013301924466689, '自流井区', NULL, '320002001', '320002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013302155153409, '贡井区', NULL, '320002002', '320002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013302306148353, '大安区', NULL, '320002003', '320002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013302457143297, '沿滩区', NULL, '320002004', '320002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013302612332545, '荣县', NULL, '320002005', '320002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013302763327489, '富顺县', NULL, '320002006', '320002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013302918516736, '攀枝花市', NULL, '320003', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013302918516737, '东区', NULL, '320003001', '320003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013303149203457, '西区', NULL, '320003002', '320003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013303300198401, '仁和区', NULL, '320003003', '320003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013303463776257, '米易县', NULL, '320003004', '320003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013303614771201, '盐边县', NULL, '320003005', '320003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013303778349056, '泸州市', NULL, '320004', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013303778349057, '江阳区', NULL, '320004001', '320004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013304189390849, '纳溪区', NULL, '320004002', '320004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013304348774401, '龙马潭区', NULL, '320004003', '320004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013304508157953, '泸县', NULL, '320004004', '320004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013304659152897, '合江县', NULL, '320004005', '320004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013304814342145, '叙永县', NULL, '320004006', '320004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013304969531393, '古蔺县', NULL, '320004007', '320004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013305120526336, '德阳市', NULL, '320005', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013305120526337, '旌阳区', NULL, '320005001', '320005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013305363795969, '中江县', NULL, '320005002', '320005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013305514790913, '罗江县', NULL, '320005003', '320005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013305695145985, '广汉市', NULL, '320005004', '320005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013305850335233, '什邡市', NULL, '320005005', '320005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013305997135873, '绵竹市', NULL, '320005006', '320005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013306152325120, '绵阳市', NULL, '320006', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013306152325121, '涪城区', NULL, '320006001', '320006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013306378817537, '游仙区', NULL, '320006002', '320006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013306529812481, '三台县', NULL, '320006003', '320006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013306685001729, '盐亭县', NULL, '320006004', '320006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013306848579585, '安县', NULL, '320006005', '320006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013306999574529, '梓潼县', NULL, '320006006', '320006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013307150569473, '北川羌族自治县', NULL, '320006007', '320006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013307301564417, '平武县', NULL, '320006008', '320006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013307456753665, '江油市', NULL, '320006009', '320006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013307603554304, '广元市', NULL, '320007', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013307603554305, '利州区', NULL, '320007001', '320007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013307825852417, '昭化区', NULL, '320007002', '320007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013307976847361, '朝天区', NULL, '320007003', '320007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013308127842305, '旺苍县', NULL, '320007004', '320007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013308278837249, '青川县', NULL, '320007005', '320007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013308417249281, '剑阁县', NULL, '320007006', '320007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013308564049921, '苍溪县', NULL, '320007007', '320007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013308715044864, '遂宁市', NULL, '320008', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013308715044865, '船山区', NULL, '320008001', '320008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013308941537281, '安居区', NULL, '320008002', '320008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013309105115137, '蓬溪县', NULL, '320008003', '320008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013309260304385, '射洪县', NULL, '320008004', '320008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013309398716417, '大英县', NULL, '320008005', '320008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013309566488576, '内江市', NULL, '320009', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013309566488577, '市中区', NULL, '320009001', '320009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013309797175297, '东兴区', NULL, '320009002', '320009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013309956558849, '威远县', NULL, '320009003', '320009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013310107553793, '资中县', NULL, '320009004', '320009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013310258548737, '隆昌县', NULL, '320009005', '320009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013310413737984, '乐山市', NULL, '320010', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013310413737985, '市中区', NULL, '320010001', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013310644424705, '沙湾区', NULL, '320010002', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013310799613953, '五通桥区', NULL, '320010003', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013310950608897, '金口河区', NULL, '320010004', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013311105798145, '犍为县', NULL, '320010005', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013311260987393, '井研县', NULL, '320010006', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013311411982337, '夹江县', NULL, '320010007', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013311562977281, '沐川县', NULL, '320010008', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013311713972225, '峨边彝族自治县', NULL, '320010009', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013311873355777, '马边彝族自治县', NULL, '320010010', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013312032739329, '峨眉山市', NULL, '320010011', '320010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013312187928576, '南充市', NULL, '320011', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013312187928577, '顺庆区', NULL, '320011001', '320011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013312418615297, '高坪区', NULL, '320011002', '320011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013312577998849, '嘉陵区', NULL, '320011003', '320011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013312733188097, '南部县', NULL, '320011004', '320011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013312879988737, '营山县', NULL, '320011005', '320011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013313035177985, '蓬安县', NULL, '320011006', '320011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013313181978625, '仪陇县', NULL, '320011007', '320011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013313332973569, '西充县', NULL, '320011008', '320011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013313479774209, '阆中市', NULL, '320011009', '320011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013313630769152, '宜宾市', NULL, '320012', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013313630769153, '翠屏区', NULL, '320012001', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013313857261569, '南溪区', NULL, '320012002', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013314004062209, '宜宾县', NULL, '320012003', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013314150862849, '江安县', NULL, '320012004', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013314301857793, '长宁县', NULL, '320012005', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013314444464129, '高县', NULL, '320012006', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013314595459073, '珙县', NULL, '320012007', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013314738065409, '筠连县', NULL, '320012008', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013314880671745, '兴文县', NULL, '320012009', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013315031666689, '屏山县', NULL, '320012010', '320012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013315178467328, '广安市', NULL, '320013', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013315178467329, '广安区', NULL, '320013001', '320013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013315409154049, '前锋区', NULL, '320013002', '320013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013315555954689, '岳池县', NULL, '320013003', '320013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013315698561025, '武胜县', NULL, '320013004', '320013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013315862138881, '邻水县', NULL, '320013005', '320013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013315996356609, '华莹市', NULL, '320013006', '320013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013316134768640, '达州市', NULL, '320014', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013316134768641, '达川区', NULL, '320014001', '320014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013316361261057, '通川区', NULL, '320014002', '320014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013316512256001, '宣汉县', NULL, '320014003', '320014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013316671639553, '开江县', NULL, '320014004', '320014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013316814245889, '大竹县', NULL, '320014005', '320014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013316948463617, '渠县', NULL, '320014006', '320014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013317141401601, '万源市', NULL, '320014007', '320014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013317304979456, '雅安市', NULL, '320015', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013317304979457, '雨城区', NULL, '320015001', '320015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013317573414913, '名山区', NULL, '320015002', '320015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013317741187073, '荥经县', NULL, '320015003', '320015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013317963485185, '汉源县', NULL, '320015004', '320015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013318110285825, '石棉县', NULL, '320015005', '320015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013318257086465, '天全县', NULL, '320015006', '320015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013318395498497, '芦山县', NULL, '320015007', '320015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013318546493441, '宝兴县', NULL, '320015008', '320015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013318689099776, '阿坝藏族羌族自治州', NULL, '320016', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013318689099777, '汶川县', NULL, '320016001', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013318915592193, '理县', NULL, '320016002', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013319066587137, '茂县', NULL, '320016003', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013319213387777, '松潘县', NULL, '320016004', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013319355994113, '九寨沟县', NULL, '320016005', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013319506989057, '金川县', NULL, '320016006', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013319653789697, '小金县', NULL, '320016007', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013319804784641, '黑水县', NULL, '320016008', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013319955779585, '马尔康市', NULL, '320016009', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013320098385921, '壤塘县', NULL, '320016010', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013320245186561, '阿坝县', NULL, '320016011', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013320391987201, '若尔盖县', NULL, '320016012', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013320547176449, '红原县', NULL, '320016013', '320016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013320702365696, '甘孜藏族自治州', NULL, '320017', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013320702365697, '康定市', NULL, '320017001', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013320941441025, '泸定县', NULL, '320017002', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013321079853057, '丹巴县', NULL, '320017003', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013321226653697, '九龙县', NULL, '320017004', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013321373454337, '雅江县', NULL, '320017005', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013321524449281, '道孚县', NULL, '320017006', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013321675444225, '炉霍县', NULL, '320017007', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013321822244865, '甘孜县', NULL, '320017008', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013321964851201, '新龙县', NULL, '320017009', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013322115846145, '德格县', NULL, '320017010', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013322271035393, '白玉县', NULL, '320017011', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013322443001857, '石渠县', NULL, '320017012', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013322589802497, '色达县', NULL, '320017013', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013322744991745, '理塘县', NULL, '320017014', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013322895986689, '巴塘县', NULL, '320017015', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013323097313281, '乡城县', NULL, '320017016', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013323252502529, '稻城县', NULL, '320017017', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013323407691777, '得荣县', NULL, '320017018', '320017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013323567075328, '凉山彝族自治州', NULL, '320018', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013323567075329, '西昌市', NULL, '320018001', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013323797762049, '木里藏族自治县', NULL, '320018002', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013323952951297, '盐源县', NULL, '320018003', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013324099751937, '德昌县', NULL, '320018004', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013324254941185, '会理县', NULL, '320018005', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013324405936129, '会东县', NULL, '320018006', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013324556931073, '宁南县', NULL, '320018007', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013324716314625, '普格县', NULL, '320018008', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013324871503873, '布拖县', NULL, '320018009', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013325018304513, '金阳县', NULL, '320018010', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013325177688065, '昭觉县', NULL, '320018011', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013325320294401, '喜德县', NULL, '320018012', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013325471289345, '冕宁县', NULL, '320018013', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013325622284289, '越西县', NULL, '320018014', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013325769084929, '甘洛县', NULL, '320018015', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013325924274177, '美姑县', NULL, '320018016', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013326079463425, '雷波县', NULL, '320018017', '320018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013326226264064, '巴中市', NULL, '320019', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013326226264065, '巴州区', NULL, '320019001', '320019', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013326456950785, '恩阳区', NULL, '320019002', '320019', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013326607945729, '通江县', NULL, '320019003', '320019', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013326763134977, '南江县', NULL, '320019004', '320019', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013326914129921, '平昌县', NULL, '320019005', '320019', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013327069319168, '眉山市', NULL, '320020', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013327069319169, '东坡区', NULL, '320020001', '320020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013327295811585, '彭山区', NULL, '320020002', '320020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013327451000833, '仁寿县', NULL, '320020003', '320020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013327601995777, '洪雅县', NULL, '320020004', '320020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013327748796417, '丹棱县', NULL, '320020005', '320020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013327891402753, '青神县', NULL, '320020006', '320020', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013328038203392, '资阳市', NULL, '320021', '320', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013328038203393, '雁江区', NULL, '320021001', '320021', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013328264695809, '安岳县', NULL, '320021002', '320021', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013328419885057, '乐至县', NULL, '320021003', '320021', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013328579268608, '贵州省', '贵州', '330', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013328679931904, '贵阳市', NULL, '330001', '330', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013328679931905, '南明区', NULL, '330001001', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013328910618625, '云岩区', NULL, '330001002', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013329070002177, '花溪区', NULL, '330001003', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013329225191425, '乌当区', NULL, '330001004', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013329376186369, '白云区', NULL, '330001005', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013329527181313, '观山湖区', NULL, '330001006', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013329682370561, '开阳县', NULL, '330001007', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013329829171201, '息烽县', NULL, '330001008', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013329984360449, '修文县', NULL, '330001009', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013330122772481, '清镇市', NULL, '330001010', '330001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013330273767424, '六盘水市', NULL, '330002', '330', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013330273767425, '钟山区', NULL, '330002001', '330002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013330504454145, '六枝特区', NULL, '330002002', '330002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013330651254785, '盘县', NULL, '330002003', '330002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013330806444033, '水城县', NULL, '330002004', '330002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013330957438976, '遵义市', NULL, '330003', '330', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013330957438977, '红花岗区', NULL, '330003001', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013331188125697, '汇川区', NULL, '330003002', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013331334926337, '遵义县', NULL, '330003003', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013331494309889, '桐梓县', NULL, '330003004', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013331649499137, '绥阳县', NULL, '330003005', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013331796299777, '正安县', NULL, '330003006', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013331947294721, '道真仡佬族苗族自治县', NULL, '330003007', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013332098289665, '务川仡佬族苗族自治县', NULL, '330003008', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013332253478913, '凤冈县', NULL, '330003009', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013332412862465, '湄潭县', NULL, '330003010', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013332568051713, '余庆县', NULL, '330003011', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013332714852353, '习水县', NULL, '330003012', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013332870041601, '赤水市', NULL, '330003013', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013333025230849, '仁怀市', NULL, '330003014', '330003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013333176225792, '铜仁市', NULL, '330004', '330', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013333176225793, '碧江区', NULL, '330004001', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013333402718209, '万山区', NULL, '330004002', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013333557907457, '江口县', NULL, '330004003', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013333708902401, '玉屏侗族自治县', NULL, '330004004', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013333864091649, '石阡县', NULL, '330004005', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013334019280897, '思南县', NULL, '330004006', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013334174470145, '印江土家族苗族自治县', NULL, '330004007', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013334317076481, '德江县', NULL, '330004008', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013334476460033, '沿河土家族自治县', NULL, '330004009', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013334619066369, '松桃苗族自治县', NULL, '330004010', '330004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013334770061312, '黔西南布依族苗族自治州', NULL, '330005', '330', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013334770061313, '兴义市', NULL, '330005001', '330005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013334996553729, '兴仁县', NULL, '330005002', '330005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013335143354369, '普安县', NULL, '330005003', '330005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013335294349313, '晴隆县', NULL, '330005004', '330005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013335432761345, '贞丰县', NULL, '330005005', '330005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013335579561985, '望谟县', NULL, '330005006', '330005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013335717974017, '册亨县', NULL, '330005007', '330005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013335856386049, '安龙县', NULL, '330005008', '330005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013336003186688, '毕节市', NULL, '330006', '330', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013336003186689, '七星关区', NULL, '330006001', '330006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013336217096193, '大方县', NULL, '330006002', '330006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013336363896833, '黔西县', NULL, '330006003', '330006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013336510697473, '金沙县', NULL, '330006004', '330006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013336661692417, '织金县', NULL, '330006005', '330006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013336804298753, '纳雍县', NULL, '330006006', '330006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013336955293697, '威宁彝族回族苗族自治县', NULL, '330006007', '330006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013337106288641, '赫章县', NULL, '330006008', '330006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013337253089280, '安顺市', NULL, '330007', '330', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013337253089281, '西秀区', NULL, '330007001', '330007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013337462804481, '平坝区', NULL, '330007002', '330007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013337613799425, '普定县', NULL, '330007003', '330007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013337756405761, '关岭布依族苗族自治县', NULL, '330007004', '330007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013337903206401, '镇宁布依族苗族自治县', NULL, '330007005', '330007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013338045812737, '紫云苗族布依族自治县', NULL, '330007006', '330007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013338196807680, '黔东南苗族侗族自治州', NULL, '330008', '330', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013338196807681, '凯里市', NULL, '330008001', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013338423300097, '黄平县', NULL, '330008002', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013338570100737, '施秉县', NULL, '330008003', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013338708512769, '三穗县', NULL, '330008004', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013338855313409, '镇远县', NULL, '330008005', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013339006308353, '岑巩县', NULL, '330008006', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013339157303297, '天柱县', NULL, '330008007', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013339295715329, '锦屏县', NULL, '330008008', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013339484459009, '剑河县', NULL, '330008009', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013339652231169, '台江县', NULL, '330008010', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013339799031809, '黎平县', NULL, '330008011', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013340067467265, '榕江县', NULL, '330008012', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013340210073601, '从江县', NULL, '330008013', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013340352679937, '雷山县', NULL, '330008014', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013340491091969, '麻江县', NULL, '330008015', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013340633698305, '丹寨县', NULL, '330008016', '330008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013340772110336, '黔南布依族苗族自治州', NULL, '330009', '330', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013340772110337, '都匀市', NULL, '330009001', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013340998602753, '福泉市', NULL, '330009002', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013341157986305, '荔波县', NULL, '330009003', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013341292204033, '贵定县', NULL, '330009004', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013341439004673, '瓮安县', NULL, '330009005', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013341585805313, '独山县', NULL, '330009006', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013341740994561, '平塘县', NULL, '330009007', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013341887795201, '罗甸县', NULL, '330009008', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013342038790145, '长顺县', NULL, '330009009', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013342181396481, '龙里县', NULL, '330009010', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013342332391425, '惠水县', NULL, '330009011', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013342474997761, '三都水族自治县', NULL, '330009012', '330009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013342621798400, '云南省', '云南', '340', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013342856679424, '昆明市', NULL, '340001', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013342856679425, '五华区', NULL, '340001001', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013343074783233, '盘龙区', NULL, '340001002', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013343221583873, '官渡区', NULL, '340001003', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013343359995905, '西山区', NULL, '340001004', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013343506796545, '东川区', NULL, '340001005', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013343653597185, '呈贡区', NULL, '340001006', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013343804592129, '晋宁区', NULL, '340001007', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013343947198465, '富民县', NULL, '340001008', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013344098193409, '宜良县', NULL, '340001009', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013344244994049, '石林彝族自治县', NULL, '340001010', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013344391794689, '嵩明县', NULL, '340001011', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013344534401025, '禄劝彝族苗族自治县', NULL, '340001012', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013344677007361, '寻甸回族自治县', NULL, '340001013', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013344823808001, '安宁市', NULL, '340001014', '340001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013344966414336, '曲靖市', NULL, '340002', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013344966414337, '麒麟区', NULL, '340002001', '340002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013345184518145, '马龙县', NULL, '340002002', '340002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013345327124481, '陆良县', NULL, '340002003', '340002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013345482313729, '师宗县', NULL, '340002004', '340002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013345624920065, '罗平县', NULL, '340002005', '340002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013345771720705, '富源县', NULL, '340002006', '340002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013345914327041, '会泽县', NULL, '340002007', '340002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013346056933377, '沾益县', NULL, '340002008', '340002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013346203734017, '宣威市', NULL, '340002009', '340002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013346337951744, '玉溪市', NULL, '340003', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013346337951745, '红塔区', NULL, '340003001', '340003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013346547666945, '江川区', NULL, '340003002', '340003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013346698661889, '澄江县', NULL, '340003003', '340003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013346849656833, '通海县', NULL, '340003004', '340003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013346992263169, '华宁县', NULL, '340003005', '340003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013347143258113, '易门县', NULL, '340003006', '340003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013347290058753, '峨山彝族自治县', NULL, '340003007', '340003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013347441053697, '新平彝族傣族自治县', NULL, '340003008', '340003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013347583660033, '元江哈尼族彝族傣族自治县', NULL, '340003009', '340003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013347730460672, '昭通市', NULL, '340004', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013347730460673, '昭阳区', NULL, '340004001', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013347944370177, '鲁甸县', NULL, '340004002', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013348086976513, '巧家县', NULL, '340004003', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013348233777153, '盐津县', NULL, '340004004', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013348363800577, '大关县', NULL, '340004005', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013348502212609, '永善县', NULL, '340004006', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013348644818945, '绥江县', NULL, '340004007', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013348795813889, '镇雄县', NULL, '340004008', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013348959391745, '彝良县', NULL, '340004009', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013349110386689, '威信县', NULL, '340004010', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013349252993025, '水富县', NULL, '340004011', '340004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013349399793664, '楚雄彝族自治州', NULL, '340005', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013349399793665, '楚雄市', NULL, '340005001', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013349617897473, '双柏县', NULL, '340005002', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013349764698113, '牟定县', NULL, '340005003', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013349907304449, '南华县', NULL, '340005004', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013350054105089, '姚安县', NULL, '340005005', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013350196711425, '大姚县', NULL, '340005006', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013350335123457, '永仁县', NULL, '340005007', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013350477729793, '元谋县', NULL, '340005008', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013350620336129, '武定县', NULL, '340005009', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013350758748161, '禄丰县', NULL, '340005010', '340005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013350905548800, '红河哈尼族彝族自治州', NULL, '340006', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013350905548801, '个旧市', NULL, '340006001', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013351127846913, '开远市', NULL, '340006002', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013351274647553, '蒙自市', NULL, '340006003', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013351417253889, '屏边苗族自治县', NULL, '340006004', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013351559860225, '建水县', NULL, '340006005', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013351702466561, '石屏县', NULL, '340006006', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013351845072897, '弥勒市', NULL, '340006007', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013351987679233, '泸西县', NULL, '340006008', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013352130285569, '元阳县', NULL, '340006009', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013352268697601, '红河县', NULL, '340006010', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013352398721025, '金平苗族瑶族傣族自治县', NULL, '340006011', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013352549715969, '绿春县', NULL, '340006012', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013352700710913, '河口瑶族自治县', NULL, '340006013', '340006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013352855900160, '文山壮族苗族自治州', NULL, '340007', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013352855900161, '文山市', NULL, '340007001', '340007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013353082392577, '砚山县', NULL, '340007002', '340007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013353224998913, '西畴县', NULL, '340007003', '340007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013353430519809, '麻栗坡县', NULL, '340007004', '340007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013353581514753, '马关县', NULL, '340007005', '340007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013353740898305, '丘北县', NULL, '340007006', '340007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013353896087553, '广南县', NULL, '340007007', '340007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013354051276801, '富宁县', NULL, '340007008', '340007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013354202271744, '普洱市', NULL, '340008', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013354202271745, '思茅区', NULL, '340008001', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013354449735681, '宁洱哈尼族彝族自治县', NULL, '340008002', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013354596536321, '墨江哈尼族自治县', NULL, '340008003', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013354751725569, '景东彝族自治县', NULL, '340008004', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013354898526209, '景谷傣族彝族自治县', NULL, '340008005', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013355053715457, '镇沅彝族哈尼族拉祜族自治县', NULL, '340008006', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013355208904705, '江城哈尼族彝族自治县', NULL, '340008007', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013355364093953, '孟连傣族拉祜族佤族自治县', NULL, '340008008', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013355515088897, '澜沧拉祜族自治县', NULL, '340008009', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013355674472449, '西盟佤族自治县', NULL, '340008010', '340008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013355833856000, '西双版纳傣族自治州', NULL, '340009', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013355833856001, '景洪市', NULL, '340009001', '340009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013356064542721, '勐海县', NULL, '340009002', '340009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013356219731969, '勐腊县', NULL, '340009003', '340009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013356370726912, '大理白族自治州', NULL, '340010', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013356370726913, '大理市', NULL, '340010001', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013356593025025, '漾濞彝族自治县', NULL, '340010002', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013356744019969, '祥云县', NULL, '340010003', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013356890820609, '宾川县', NULL, '340010004', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013357046009857, '弥渡县', NULL, '340010005', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013357188616193, '南涧彝族自治县', NULL, '340010006', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013357339611137, '巍山彝族回族自治县', NULL, '340010007', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013357482217473, '永平县', NULL, '340010008', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013357633212417, '云龙县', NULL, '340010009', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013357780013057, '洱源县', NULL, '340010010', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013357931008001, '剑川县', NULL, '340010011', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013358077808641, '鹤庆县', NULL, '340010012', '340010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013358232997888, '保山市', NULL, '340011', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013358232997889, '隆阳区', NULL, '340011001', '340011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013358463684609, '施甸县', NULL, '340011002', '340011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013358614679553, '腾冲市', NULL, '340011003', '340011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013358757285889, '龙陵县', NULL, '340011004', '340011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013358908280833, '昌宁县', NULL, '340011005', '340011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013359063470080, '德宏傣族景颇族自治州', NULL, '340012', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013359063470081, '瑞丽市', NULL, '340012001', '340012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013359281573889, '芒市', NULL, '340012002', '340012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013359428374529, '梁河县', NULL, '340012003', '340012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013359575175169, '盈江县', NULL, '340012004', '340012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013359726170113, '陇川县', NULL, '340012005', '340012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013359877165056, '丽江市', '丽江市', '340013', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013359877165057, '古城区', NULL, '340013001', '340013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013360107851777, '玉龙纳西族自治县', NULL, '340013002', '340013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013360263041025, '永胜县', NULL, '340013003', '340013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013360418230273, '华坪县', NULL, '340013004', '340013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013360569225217, '宁蒗彝族自治县', NULL, '340013005', '340013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013360724414464, '怒江傈僳族自治州', '怒江傈僳族自治州', '340014', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013360724414465, '泸水市', NULL, '340014001', '340014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013360946712577, '福贡县', NULL, '340014002', '340014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013361101901825, '贡山独龙族怒族自治县', NULL, '340014003', '340014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013361244508161, '兰坪白族普米族自治县', NULL, '340014004', '340014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013361399697408, '迪庆藏族自治州', '迪庆藏族自治州', '340015', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013361399697409, '香格里拉市', NULL, '340015001', '340015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013361626189825, '德钦县', NULL, '340015002', '340015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013361772990465, '维西傈僳族自治县', NULL, '340015003', '340015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013361928179712, '临沧市', '临沧市', '340016', '340', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013361928179713, '临翔区', NULL, '340016001', '340016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013362163060737, '凤庆县', NULL, '340016002', '340016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013362347610113, '云县', NULL, '340016003', '340016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013362490216449, '永德县', NULL, '340016004', '340016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013362645405697, '镇康县', NULL, '340016005', '340016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013362792206337, '双江拉祜族佤族布朗族傣族自治县', NULL, '340016006', '340016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013362947395585, '耿马傣族佤族自治县', NULL, '340016007', '340016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013363102584833, '沧源佤族自治县', NULL, '340016008', '340016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013363249385472, '西藏', '西藏', '350', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013363366825984, '拉萨市', '拉萨市', '350001', '350', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013363366825985, '城关区', NULL, '350001001', '350001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013363605901313, '林周县', NULL, '350001002', '350001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013363819810817, '当雄县', NULL, '350001003', '350001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013363966611457, '尼木县', NULL, '350001004', '350001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013364121800705, '曲水县', NULL, '350001005', '350001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013364276989953, '堆龙德庆县', NULL, '350001006', '350001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013364427984897, '达孜县', NULL, '350001007', '350001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013364583174145, '墨竹工卡县', NULL, '350001008', '350001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013364738363392, '昌都市', '昌都市', '350002', '350', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013364738363393, '卡若区', NULL, '350002001', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013364973244417, '江达县', NULL, '350002002', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013365120045057, '贡觉县', NULL, '350002003', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013365275234305, '类乌齐县', NULL, '350002004', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013365430423553, '丁青县', NULL, '350002005', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013365568835585, '察雅县', NULL, '350002006', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013365711441921, '八宿县', NULL, '350002007', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013365858242561, '左贡县', NULL, '350002008', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013365996654593, '芒康县', NULL, '350002009', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013366143455233, '洛隆县', NULL, '350002010', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013366290255873, '边坝县', NULL, '350002011', '350002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013366437056512, '山南地区', '山南地区', '350003', '350', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013366437056513, '乃东县', NULL, '350003001', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013366663548929, '扎囊县', NULL, '350003002', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013366810349569, '贡嘎县', NULL, '350003003', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013366957150209, '桑日县', NULL, '350003004', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013367103950849, '琼结县', NULL, '350003005', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013367242362881, '曲松县', NULL, '350003006', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013367393357825, '措美县', NULL, '350003007', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013367535964161, '洛扎县', NULL, '350003008', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013367712124929, '加查县', NULL, '350003009', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013367858925569, '隆子县', NULL, '350003010', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013368005726209, '错那县', NULL, '350003011', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013368148332545, '浪卡子县', NULL, '350003012', '350003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013368286744576, '日喀则市', '日喀则市', '350004', '350', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013368286744577, '桑珠孜区', NULL, '350004001', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013368517431297, '南木林县', NULL, '350004002', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013368672620545, '江孜县', NULL, '350004003', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013368823615489, '定日县', NULL, '350004004', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013368978804737, '萨迦县', NULL, '350004005', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013369133993985, '拉孜县', NULL, '350004006', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013369272406017, '昂仁县', NULL, '350004007', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013369419206657, '谢通门县', NULL, '350004008', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013369566007297, '白朗县', NULL, '350004009', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013369708613633, '仁布县', NULL, '350004010', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013369851219969, '康马县', NULL, '350004011', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013369993826305, '定结县', NULL, '350004012', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013370144821249, '仲巴县', NULL, '350004013', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013370291621889, '亚东县', NULL, '350004014', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013370438422529, '吉隆县', NULL, '350004015', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013370585223169, '聂拉木县', NULL, '350004016', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013370723635201, '萨嘎县', NULL, '350004017', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013370870435841, '岗巴县', NULL, '350004018', '350004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013371013042176, '那曲地区', '那曲地区', '350005', '350', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013371013042177, '那曲县', NULL, '350005001', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013371449249793, '嘉黎县', NULL, '350005002', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013371591856129, '比如县', NULL, '350005003', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013371734462465, '聂荣县', NULL, '350005004', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013371893846017, '安多县', NULL, '350005005', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013372053229569, '申扎县', NULL, '350005006', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013372204224513, '索县', NULL, '350005007', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013372351025153, '班戈县', NULL, '350005008', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013372506214401, '双湖县', NULL, '350005009', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013372648820737, '巴青县', NULL, '350005010', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013372799815681, '尼玛县', NULL, '350005011', '350005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013372946616320, '阿里地区', '阿里地区', '350006', '350', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013372946616321, '普兰县', NULL, '350006001', '350006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013373177303041, '札达县', NULL, '350006002', '350006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013373332492289, '噶尔县', NULL, '350006003', '350006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013373487681537, '日土县', NULL, '350006004', '350006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013373647065089, '革吉县', NULL, '350006005', '350006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013373793865729, '改则县', NULL, '350006006', '350006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013373944860673, '措勤县', NULL, '350006007', '350006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013374095855616, '林芝地区', '林芝地区', '350007', '350', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013374095855617, '林芝县', NULL, '350007001', '350007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013374326542337, '工布江达县', NULL, '350007002', '350007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013374477537281, '米林县', NULL, '350007003', '350007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013374624337921, '墨脱县', NULL, '350007004', '350007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013374779527169, '波密县', NULL, '350007005', '350007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013374938910721, '察隅县', NULL, '350007006', '350007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013375106682881, '朗县', NULL, '350007007', '350007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013375261872128, '陕西省', '陕西', '360', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013375379312640, '西安市', '西安市', '360001', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013375379312641, '新城区', NULL, '360001001', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013375618387969, '碑林区', NULL, '360001002', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013375765188609, '莲湖区', NULL, '360001003', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013375924572161, '灞桥区', NULL, '360001004', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013376075567105, '未央区', NULL, '360001005', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013376230756353, '雁塔区', NULL, '360001006', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013376381751297, '阎良区', NULL, '360001007', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013376536940545, '临潼区', NULL, '360001008', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013376687935489, '长安区', NULL, '360001009', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013376838930433, '高陵区', NULL, '360001010', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013376994119681, '鄠邑区', NULL, '360001011', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013377149308929, '周至县', NULL, '360001012', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013377300303873, '蓝田县', NULL, '360001013', '360001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013377463881728, '铜川市', '铜川市', '360002', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013377463881729, '王益区', NULL, '360002001', '360002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013377690374145, '印台区', NULL, '360002002', '360002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013377845563393, '耀州区', NULL, '360002003', '360002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013378000752641, '宜君县', NULL, '360002004', '360002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013378147553280, '宝鸡市', '宝鸡市', '360003', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013378147553281, '渭滨区', NULL, '360003001', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013378374045697, '金台区', NULL, '360003002', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013378520846337, '陈仓区', NULL, '360003003', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013378663452673, '凤翔县', NULL, '360003004', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013378822836225, '岐山县', NULL, '360003005', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013378973831169, '扶风县', NULL, '360003006', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013379124826113, '眉县', NULL, '360003007', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013379275821057, '陇县', NULL, '360003008', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013379426816001, '千阳县', NULL, '360003009', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013379577810945, '麟游县', NULL, '360003010', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013379716222977, '凤县', NULL, '360003011', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013379863023617, '太白县', NULL, '360003012', '360003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013380009824256, '咸阳市', '咸阳市', '360004', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013380009824257, '秦都区', NULL, '360004001', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013380227928065, '杨陵区', NULL, '360004002', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013380374728705, '渭城区', NULL, '360004003', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013380525723649, '三原县', NULL, '360004004', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013380668329985, '泾阳县', NULL, '360004005', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013380831907841, '乾县', NULL, '360004006', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013380987097089, '礼泉县', NULL, '360004007', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013381133897729, '永寿县', NULL, '360004008', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013381289086977, '彬县', NULL, '360004009', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013381444276225, '长武县', NULL, '360004010', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013381595271169, '旬邑县', NULL, '360004011', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013381750460417, '淳化县', NULL, '360004012', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013381909843969, '武功县', NULL, '360004013', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013382060838913, '兴平市', NULL, '360004014', '360004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013382216028160, '渭南市', '渭南市', '360005', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013382216028161, '临渭区', NULL, '360005001', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013382442520577, '华州区', NULL, '360005002', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013382597709825, '潼关县', NULL, '360005003', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013382752899073, '大荔县', NULL, '360005004', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013382908088321, '合阳县', NULL, '360005005', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013383063277569, '澄城县', NULL, '360005006', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013383218466817, '蒲城县', NULL, '360005007', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013383361073153, '白水县', NULL, '360005008', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013383507873793, '富平县', NULL, '360005009', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013383650480129, '韩城市', NULL, '360005010', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013383805669377, '华阴市', NULL, '360005011', '360005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013383956664320, '延安市', '延安市', '360006', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013383956664321, '宝塔区', NULL, '360006001', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013384191545345, '安塞区', NULL, '360006002', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013384346734593, '延长县', NULL, '360006003', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013384501923841, '延川县', NULL, '360006004', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013384661307393, '子长县', NULL, '360006005', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013384812302337, '志丹县', NULL, '360006006', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013384963297281, '吴旗县', NULL, '360006007', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013385122680833, '甘泉县', NULL, '360006008', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013385273675777, '富县', NULL, '360006009', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013385420476417, '洛川县', NULL, '360006010', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013385579859969, '宜川县', NULL, '360006011', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013385726660609, '黄龙县', NULL, '360006012', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013385877655553, '黄陵县', NULL, '360006013', '360006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013386032844800, '汉中市', '汉中市', '360007', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013386032844801, '汉台区', NULL, '360007001', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013386267725825, '南郑县', NULL, '360007002', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013386427109377, '城固县', NULL, '360007003', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013386578104321, '洋县', NULL, '360007004', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013386733293569, '西乡县', NULL, '360007005', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013386888482817, '勉县', NULL, '360007006', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013387039477761, '宁强县', NULL, '360007007', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013387194667009, '略阳县', NULL, '360007008', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013387345661953, '镇巴县', NULL, '360007009', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013387505045505, '留坝县', NULL, '360007010', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013387647651841, '佛坪县', NULL, '360007011', '360007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013387807035392, '安康市', '安康市', '360008', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013387807035393, '汉滨区', NULL, '360008001', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013388037722113, '汉阴县', NULL, '360008002', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013388192911361, '石泉县', NULL, '360008003', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013388343906305, '宁陕县', NULL, '360008004', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013388503289857, '紫阳县', NULL, '360008005', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013388654284801, '岚皋县', NULL, '360008006', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013388809474049, '平利县', NULL, '360008007', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013388956274689, '镇坪县', NULL, '360008008', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013389111463937, '旬阳县', NULL, '360008009', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013389283430401, '白河县', NULL, '360008010', '360008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013389438619648, '商洛市', '商洛市', '360009', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013389438619649, '商州区', NULL, '360009001', '360009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013389665112065, '洛南县', NULL, '360009002', '360009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013389816107009, '丹凤县', NULL, '360009003', '360009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013389975490561, '商南县', NULL, '360009004', '360009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013390134874113, '山阳县', NULL, '360009005', '360009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013390290063361, '镇安县', NULL, '360009006', '360009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013390441058305, '柞水县', NULL, '360009007', '360009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013390604636160, '榆林市', '榆林市', '360010', '360', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013390604636161, '榆阳区', NULL, '360010001', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013390839517185, '横山区', NULL, '360010002', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013390994706433, '神木县', NULL, '360010003', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013391149895681, '府谷县', NULL, '360010004', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013391300890625, '靖边县', NULL, '360010005', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013391451885569, '定边县', NULL, '360010006', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013391611269121, '绥德县', NULL, '360010007', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013391758069761, '米脂县', NULL, '360010008', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013391909064705, '佳县', NULL, '360010009', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013392064253953, '吴堡县', NULL, '360010010', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013392211054593, '清涧县', NULL, '360010011', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013392366243841, '子洲县', NULL, '360010012', '360010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013392521433088, '甘肃省', '甘肃', '370', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013392626290688, '兰州市', '兰州市', '370001', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013392626290689, '城关区', NULL, '370001001', '370001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013392861171713, '七里河区', NULL, '370001002', '370001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013393012166657, '西固区', NULL, '370001003', '370001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013393167355905, '安宁区', NULL, '370001004', '370001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013393318350849, '红古区', NULL, '370001005', '370001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013393477734401, '永登县', NULL, '370001006', '370001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013393628729345, '皋兰县', NULL, '370001007', '370001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013393775529985, '榆中县', NULL, '370001008', '370001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013393930719232, '嘉峪关市', '嘉峪关市', '370002', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013393930719233, '嘉峪关市', NULL, '370002001', '370002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013394157211648, '金昌市', '金昌市', '370003', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013394157211649, '金川区', NULL, '370003001', '370003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013394396286977, '永昌县', NULL, '370003002', '370003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013394559864832, '白银市', '白银市', '370004', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013394559864833, '白银区', NULL, '370004001', '370004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013394786357249, '平川区', NULL, '370004002', '370004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013394941546497, '靖远县', NULL, '370004003', '370004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013395100930049, '会宁县', NULL, '370004004', '370004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013395247730689, '景泰县', NULL, '370004005', '370004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013395398725632, '天水市', '天水市', '370005', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013395398725633, '秦州区', NULL, '370005001', '370005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013395633606657, '麦积区', NULL, '370005002', '370005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013395792990209, '清水县', NULL, '370005003', '370005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013395948179457, '秦安县', NULL, '370005004', '370005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013396115951617, '甘谷县', NULL, '370005005', '370005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013396262752257, '武山县', NULL, '370005006', '370005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013396409552897, '张家川回族自治县', NULL, '370005007', '370005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013396585713664, '酒泉市', '酒泉市', '370006', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013396585713665, '肃州区', NULL, '370006001', '370006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013396820594689, '玉门市', NULL, '370006002', '370006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013396979978241, '敦煌市', NULL, '370006003', '370006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013397130973185, '金塔县', NULL, '370006004', '370006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013397281968129, '肃北蒙古族自治县', NULL, '370006005', '370006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013397432963073, '阿克塞哈萨克族自治县', NULL, '370006006', '370006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013397588152321, '安西县', NULL, '370006007', '370006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013397743341568, '张掖市', '张掖市', '370007', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013397743341569, '甘州区', NULL, '370007001', '370007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013397969833985, '肃南裕固族自治县', NULL, '370007002', '370007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013398129217537, '民乐县', NULL, '370007003', '370007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013398280212481, '临泽县', NULL, '370007004', '370007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013398427013121, '高台县', NULL, '370007005', '370007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013398573813761, '山丹县', NULL, '370007006', '370007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013398720614400, '武威市', '武威市', '370008', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013398720614401, '凉州区', NULL, '370008001', '370008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013398951301121, '民勤县', NULL, '370008002', '370008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013399093907457, '古浪县', NULL, '370008003', '370008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013399249096705, '天祝藏族自治县', NULL, '370008004', '370008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013399395897344, '定西市', '定西市', '370009', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013399395897345, '安定区', NULL, '370009001', '370009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013399609806849, '通渭县', NULL, '370009002', '370009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013399764996097, '陇西县', NULL, '370009003', '370009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013399915991041, '渭源县', NULL, '370009004', '370009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013400066985985, '临洮县', NULL, '370009005', '370009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013400217980929, '漳县', NULL, '370009006', '370009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013400368975873, '岷县', NULL, '370009007', '370009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013400511582208, '陇南市', '陇南市', '370010', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013400511582209, '武都区', NULL, '370010001', '370010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013400746463233, '宕昌县', NULL, '370010002', '370010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013400897458177, '成县', NULL, '370010003', '370010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013401056841729, '康县', NULL, '370010004', '370010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013401207836673, '文县', NULL, '370010005', '370010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013401350443009, '西和县', NULL, '370010006', '370010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013401493049345, '礼县', NULL, '370010007', '370010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013401639849985, '两当县', NULL, '370010008', '370010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013401799233537, '徽县', NULL, '370010009', '370010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013401954422784, '平凉市', '平凉市', '370011', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013401954422785, '崆峒区', NULL, '370011001', '370011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013402172526593, '泾川县', NULL, '370011002', '370011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013402315132929, '灵台县', NULL, '370011003', '370011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013402470322177, '崇信县', NULL, '370011004', '370011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013402621317121, '华亭县', NULL, '370011005', '370011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013402776506369, '庄浪县', NULL, '370011006', '370011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013402927501313, '静宁县', NULL, '370011007', '370011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013403065913344, '庆阳市', '庆阳市', '370012', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013403065913345, '西峰区', NULL, '370012001', '370012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013403296600065, '庆城县', NULL, '370012002', '370012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013403447595009, '环县', NULL, '370012003', '370012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013403590201345, '华池县', NULL, '370012004', '370012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013403741196289, '合水县', NULL, '370012005', '370012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013403892191233, '正宁县', NULL, '370012006', '370012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013404051574785, '宁县', NULL, '370012007', '370012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013404202569729, '镇原县', NULL, '370012008', '370012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013404357758976, '临夏回族自治州', '临夏回族自治州', '370013', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013404357758977, '临夏市', NULL, '370013001', '370013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013404584251393, '临夏县', NULL, '370013002', '370013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013404735246337, '康乐县', NULL, '370013003', '370013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013404894629889, '永靖县', NULL, '370013004', '370013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013405045624833, '广河县', NULL, '370013005', '370013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013405196619777, '和政县', NULL, '370013006', '370013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013405343420417, '东乡族自治县', NULL, '370013007', '370013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013405490221057, '积石山保安族东乡族撒拉族自治县', NULL, '370013008', '370013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013405645410304, '甘南藏族自治州', '甘南藏族自治州', '370014', '370', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013405645410305, '合作市', NULL, '370014001', '370014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013405871902721, '临潭县', NULL, '370014002', '370014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013406027091969, '卓尼县', NULL, '370014003', '370014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013406173892609, '舟曲县', NULL, '370014004', '370014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013406320693249, '迭部县', NULL, '370014005', '370014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013406471688193, '玛曲县', NULL, '370014006', '370014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013406631071745, '碌曲县', NULL, '370014007', '370014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013406777872385, '夏河县', NULL, '370014008', '370014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013406933061632, '青海省', '青海', '380', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013407050502144, '西宁市', '西宁市', '380001', '380', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013407050502145, '城东区', NULL, '380001001', '380001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013407276994561, '城中区', NULL, '380001002', '380001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013407427989505, '城西区', NULL, '380001003', '380001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013407574790145, '城北区', NULL, '380001004', '380001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013407721590785, '湟中县', NULL, '380001005', '380001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013407876780033, '湟源县', NULL, '380001006', '380001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013408027774977, '大通回族土族自治县', NULL, '380001007', '380001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013408178769920, '海东市', '海东市', '380002', '380', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013408178769921, '乐都区', NULL, '380002001', '380002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013408409456641, '平安县', NULL, '380002002', '380002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013408564645889, '民和回族土族自治县', NULL, '380002003', '380002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013408715640833, '互助土族自治县', NULL, '380002004', '380002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013408866635777, '化隆回族自治县', NULL, '380002005', '380002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013409021825025, '循化撒拉族自治县', NULL, '380002006', '380002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013409181208576, '海北藏族自治州', '海北藏族自治州', '380003', '380', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013409181208577, '门源回族自治县', NULL, '380003001', '380003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013409411895297, '祁连县', NULL, '380003002', '380003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013409562890241, '海晏县', NULL, '380003003', '380003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013409709690881, '刚察县', NULL, '380003004', '380003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013409860685824, '黄南藏族自治州', '黄南藏族自治州', '380004', '380', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013409860685825, '同仁县', NULL, '380004001', '380004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013410087178241, '尖扎县', NULL, '380004002', '380004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013410242367489, '泽库县', NULL, '380004003', '380004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013410393362433, '河南蒙古族自治县', NULL, '380004004', '380004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013410540163072, '海南藏族自治州', '海南藏族自治州', '380005', '380', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013410540163073, '共和县', NULL, '380005001', '380005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013410770849793, '同德县', NULL, '380005002', '380005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013410926039041, '贵德县', NULL, '380005003', '380005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013411081228289, '兴海县', NULL, '380005004', '380005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013411232223233, '贵南县', NULL, '380005005', '380005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013411383218176, '果洛藏族自治州', '果洛藏族自治州', '380006', '380', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013411383218177, '玛沁县', NULL, '380006001', '380006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013411622293505, '班玛县', NULL, '380006002', '380006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013411777482753, '甘德县', NULL, '380006003', '380006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013411932672001, '达日县', NULL, '380006004', '380006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013412087861249, '久治县', NULL, '380006005', '380006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013412238856193, '玛多县', NULL, '380006006', '380006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013412394045440, '玉树藏族自治州', '玉树藏族自治州', '380007', '380', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013412394045441, '玉树市', NULL, '380007001', '380007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013412620537857, '杂多县', NULL, '380007002', '380007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013412763144193, '称多县', NULL, '380007003', '380007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013412922527745, '治多县', NULL, '380007004', '380007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013413056745473, '囊谦县', NULL, '380007005', '380007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013413203546113, '曲麻莱县', NULL, '380007006', '380007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013413354541056, '海西蒙古族藏族自治州', '海西蒙古族藏族自治州', '380008', '380', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013413354541057, '格尔木市', NULL, '380008001', '380008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013413585227777, '德令哈市', NULL, '380008002', '380008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013413740417025, '乌兰县', NULL, '380008003', '380008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013413895606273, '都兰县', NULL, '380008004', '380008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013414054989825, '天峻县', NULL, '380008005', '380008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013414205984768, '宁夏', '宁夏', '390', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013414323425280, '银川市', '银川市', '390001', '390', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013414323425281, '兴庆区', NULL, '390001001', '390001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013414554112001, '西夏区', NULL, '390001002', '390001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013414717689857, '金凤区', NULL, '390001003', '390001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013414860296193, '永宁县', NULL, '390001004', '390001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013415015485441, '贺兰县', NULL, '390001005', '390001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013415166480385, '灵武市', NULL, '390001006', '390001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013415321669632, '石嘴山市', '石嘴山市', '390002', '390', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013415321669633, '大武口区', NULL, '390002001', '390002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013415552356353, '惠农区', NULL, '390002002', '390002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013415707545601, '平罗县', NULL, '390002003', '390002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013415866929152, '吴忠市', '吴忠市', '390003', '390', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013415866929153, '利通区', NULL, '390003001', '390003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013416093421569, '红寺堡区', NULL, '390003002', '390003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013416252805121, '盐池县', NULL, '390003003', '390003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013416399605761, '同心县', NULL, '390003004', '390003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013416550600705, '青铜峡市', NULL, '390003005', '390003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013416697401344, '固原市', '固原市', '390004', '390', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013416697401345, '原州区', NULL, '390004001', '390004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013416928088065, '西吉县', NULL, '390004002', '390004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013417079083009, '隆德县', NULL, '390004003', '390004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013417230077953, '泾源县', NULL, '390004004', '390004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013417381072897, '彭阳县', NULL, '390004005', '390004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013417532067840, '中卫市', '中卫市', '390005', '390', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013417532067841, '沙坡头区', NULL, '390005001', '390005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013417758560257, '中宁县', NULL, '390005002', '390005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013417905360897, '海原县', NULL, '390005003', '390005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013418047967232, '新疆', '新疆', '400', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013418173796352, '乌鲁木齐市', '乌鲁木齐市', '400001', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013418173796353, '天山区', NULL, '400001001', '400001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013418396094465, '沙依巴克区', NULL, '400001002', '400001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013418555478017, '新市区', NULL, '400001003', '400001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013418710667265, '水磨沟区', NULL, '400001004', '400001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013418857467905, '头屯河区', NULL, '400001005', '400001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013419012657153, '南山矿区', NULL, '400001006', '400001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013419159457793, '东山区', NULL, '400001007', '400001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013419310452737, '乌鲁木齐县', NULL, '400001008', '400001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013419469836288, '克拉玛依市', '克拉玛依市', '400002', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013419469836289, '独山子区', NULL, '400002001', '400002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013419696328705, '克拉玛依区', NULL, '400002002', '400002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013419838935041, '白碱滩区', NULL, '400002003', '400002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013419989929985, '乌尔禾区', NULL, '400002004', '400002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013420136730624, '吐鲁番地区', '吐鲁番地区', '400003', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013420136730625, '吐鲁番市', NULL, '400003001', '400003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013420367417345, '鄯善县', NULL, '400003002', '400003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013420518412289, '托克逊县', NULL, '400003003', '400003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013420669407232, '哈密地区', '哈密地区', '400004', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013420669407233, '哈密市', NULL, '400004001', '400004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013420904288257, '巴里坤哈萨克自治县', NULL, '400004002', '400004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013421059477505, '伊吾县', NULL, '400004003', '400004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013421214666752, '昌吉回族自治州', '昌吉回族自治州', '400005', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013421214666753, '昌吉市', NULL, '400005001', '400005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013421445353473, '阜康市', NULL, '400005002', '400005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013421592154113, '呼图壁县', NULL, '400005003', '400005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013421738954753, '玛纳斯县', NULL, '400005004', '400005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013421894144001, '奇台县', NULL, '400005005', '400005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013422045138945, '吉木萨尔县', NULL, '400005006', '400005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013422187745281, '木垒哈萨克自治县', NULL, '400005007', '400005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013422330351616, '博尔塔拉蒙古自治州', '博尔塔拉蒙古自治州', '400006', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013422330351617, '阿拉山口市', NULL, '400006001', '400006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013422565232641, '博乐市', NULL, '400006002', '400006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013422720421889, '精河县', NULL, '400006003', '400006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013422875611137, '温泉县', NULL, '400006004', '400006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013423034994688, '巴音郭楞蒙古自治州', '巴音郭楞蒙古自治州', '400007', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013423034994689, '库尔勒市', NULL, '400007001', '400007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013423269875713, '轮台县', NULL, '400007002', '400007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013423416676353, '尉犁县', NULL, '400007003', '400007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013423576059905, '若羌县', NULL, '400007004', '400007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013423735443457, '且末县', NULL, '400007005', '400007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013423886438400, '焉耆回族自治县', NULL, '400007006', '400007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013424037433345, '和静县', NULL, '400007007', '400007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013424201011201, '和硕县', NULL, '400007008', '400007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013424360394753, '博湖县', NULL, '400007009', '400007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013424523972608, '阿克苏地区', '阿克苏地区', '400008', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013424523972609, '阿克苏市', NULL, '400008001', '400008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013424750465025, '温宿县', NULL, '400008002', '400008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013424905654273, '库车县', NULL, '400008003', '400008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013425052454913, '沙雅县', NULL, '400008004', '400008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013425199255553, '新和县', NULL, '400008005', '400008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013425341861889, '拜城县', NULL, '400008006', '400008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013425488662529, '乌什县', NULL, '400008007', '400008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013425643851777, '阿瓦提县', NULL, '400008008', '400008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013425799041025, '柯坪县', NULL, '400008009', '400008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013425954230272, '克孜勒苏柯尔克孜自治州', '克孜勒苏柯尔克孜自治州', '400009', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013425954230273, '阿图什市', NULL, '400009001', '400009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013426176528385, '阿克陶县', NULL, '400009002', '400009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013426327523329, '阿合奇县', NULL, '400009003', '400009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013426482712577, '乌恰县', NULL, '400009004', '400009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013426621124608, '喀什地区', '喀什地区', '400010', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013426621124609, '喀什市', NULL, '400010001', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013426868588545, '疏附县', NULL, '400010002', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013427015389185, '疏勒县', NULL, '400010003', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013427178967041, '英吉沙县', NULL, '400010004', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013427338350593, '泽普县', NULL, '400010005', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013427480956929, '莎车县', NULL, '400010006', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013428013633537, '叶城县', NULL, '400010007', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013428168822785, '麦盖提县', NULL, '400010008', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013428328206337, '岳普湖县', NULL, '400010009', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013428483395585, '伽师县', NULL, '400010010', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013428638584833, '巴楚县', NULL, '400010011', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013428793774081, '塔什库尔干塔吉克自治县', NULL, '400010012', '400010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013428944769024, '和田地区', '和田地区', '400011', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013428944769025, '和田市', NULL, '400011001', '400011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013429167067137, '和田县', NULL, '400011002', '400011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013429322256385, '墨玉县', NULL, '400011003', '400011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013429481639937, '皮山县', NULL, '400011004', '400011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013429632634881, '洛浦县', NULL, '400011005', '400011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013429787824129, '策勒县', NULL, '400011006', '400011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013429930430465, '于田县', NULL, '400011007', '400011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013430085619713, '民丰县', NULL, '400011008', '400011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013430232420352, '伊犁哈萨克自治州', '伊犁哈萨克自治州', '400012', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013430232420353, '奎屯市', NULL, '400012001', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013430454718465, '霍尔果斯市', NULL, '400012002', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013430609907713, '伊宁市', NULL, '400012003', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013430760902657, '伊宁县', NULL, '400012004', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013430916091905, '察布查尔锡伯自治县', NULL, '400012005', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013431062892545, '霍城县', NULL, '400012006', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013431205498881, '巩留县', NULL, '400012007', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013431352299521, '新源县', NULL, '400012008', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013431499100161, '昭苏县', NULL, '400012009', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013431650095105, '特克斯县', NULL, '400012010', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013431796895745, '尼勒克县', NULL, '400012011', '400012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013431960473600, '塔城地区', '塔城地区', '400013', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013431960473601, '塔城市', NULL, '400013001', '400013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013432203743233, '乌苏市', NULL, '400013002', '400013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013432354738177, '额敏县', NULL, '400013003', '400013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013432509927425, '沙湾县', NULL, '400013004', '400013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013432660922369, '托里县', NULL, '400013005', '400013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013432811917313, '裕民县', NULL, '400013006', '400013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013432971300865, '和布克赛尔蒙古自治县', NULL, '400013007', '400013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013433122295808, '阿勒泰地区', '阿勒泰地区', '400014', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013433122295809, '阿勒泰市', NULL, '400014001', '400014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013433361371137, '布尔津县', NULL, '400014002', '400014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013433508171777, '富蕴县', NULL, '400014003', '400014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013433663361025, '福海县', NULL, '400014004', '400014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013433814355969, '哈巴河县', NULL, '400014005', '400014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013433961156609, '青河县', NULL, '400014006', '400014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013434112151553, '吉木乃县', NULL, '400014007', '400014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013434250563584, '省直辖行政单位', '省直辖行政单位', '400015', '400', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013434250563585, '石河子市', NULL, '400015001', '400015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013434472861697, '阿拉尔市', NULL, '400015002', '400015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013434623856641, '图木舒克市', NULL, '400015003', '400015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013434779045889, '北屯市', NULL, '400015004', '400015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013434934235137, '铁门关市', NULL, '400015005', '400015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013435089424385, '双河市', NULL, '400015006', '400015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013435236225025, '五家渠市', NULL, '400015007', '400015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013435395608576, '台湾省', '台湾', '410', '1', '1', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013435521437696, '台北市', '台北市', '410001', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013435521437697, '', NULL, '410001001', '410001', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013435747930112, '高雄市', '高雄市', '410002', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013435747930113, '', NULL, '410002001', '410002', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013435974422528, '基隆市', '基隆市', '410003', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013435974422529, '', NULL, '410003001', '410003', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013436188332032, '台中市', '台中市', '410004', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013436188332033, '', NULL, '410004001', '410004', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013436414824448, '台南市', '台南市', '410005', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013436414824449, '', NULL, '410005001', '410005', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013436645511168, '新竹市', '新竹市', '410006', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013436645511169, '', NULL, '410006001', '410006', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013436876197888, '嘉义市', '嘉义市', '410007', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013436876197889, '', NULL, '410007001', '410007', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013437106884608, '新北市', '新北市', '410008', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013437106884609, '', NULL, '410008001', '410008', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013437333377024, '宜兰县', NULL, '410009', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013437333377025, '', NULL, '410009001', '410009', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013437564063744, '桃园县', NULL, '410010', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013437564063745, '', NULL, '410010001', '410010', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013437790556160, '新竹县', NULL, '410011', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013437790556161, '', NULL, '410011001', '410011', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438021242880, '苗栗县', NULL, '410012', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438021242881, '', NULL, '410012001', '410012', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438251929600, '彰化县', NULL, '410013', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438251929601, '', NULL, '410013001', '410013', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438486810624, '南投县', NULL, '410014', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438486810625, '', NULL, '410014001', '410014', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438717497344, '云林县', NULL, '410015', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438717497345, '', NULL, '410015001', '410015', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438931406848, '嘉义县', NULL, '410016', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013438931406849, '', NULL, '410016001', '410016', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013439153704960, '屏东县', NULL, '410017', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013439153704961, '', NULL, '410017001', '410017', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013439388585984, '台东县', NULL, '410018', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013439388585985, '', NULL, '410018001', '410018', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013439619272704, '花莲县', NULL, '410019', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013439619272705, '', NULL, '410019001', '410019', '3', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013439849959424, '澎湖县', NULL, '410020', '410', '2', NULL, NULL);
INSERT INTO `t_base_area` VALUES (1013439849959425, '', NULL, '410020001', '410020', '3', NULL, NULL);

-- ----------------------------
-- Table structure for t_base_building_important_part
-- ----------------------------
DROP TABLE IF EXISTS `t_base_building_important_part`;
CREATE TABLE `t_base_building_important_part`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片url',
  `picture_describe` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片描述',
  `building_id` bigint(20) NULL DEFAULT NULL COMMENT '建筑物id',
  `foor` int(255) NULL DEFAULT NULL COMMENT '层数',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体地址',
  `fire_extinguisher_type` int(2) NULL DEFAULT NULL COMMENT '灭火器类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_building_important_part
-- ----------------------------
INSERT INTO `t_base_building_important_part` VALUES (5, 'rtyh/455.jpg', '墙角容易起火', 5, 65, NULL, 1);
INSERT INTO `t_base_building_important_part` VALUES (353802368281427968, '5454/521654/56.jpg', NULL, 353035058969001984, 4, '电梯口', 2);
INSERT INTO `t_base_building_important_part` VALUES (353802368352731136, '558654/52544/57686.jpg', NULL, 353035058969001984, 2, '储物间', 2);
INSERT INTO `t_base_building_important_part` VALUES (353802734087651328, '5454/521654/56.jpg', NULL, 353035058969001984, 4, '电梯口', 2);
INSERT INTO `t_base_building_important_part` VALUES (353802734154760192, '558654/52544/57686.jpg', NULL, 353035058969001984, 2, '储物间', 2);
INSERT INTO `t_base_building_important_part` VALUES (353803373375078400, '5454/521654/56.jpg', NULL, 353035058969001984, 4, '电梯口', 2);
INSERT INTO `t_base_building_important_part` VALUES (353803373467353088, '558654/52544/57686.jpg', NULL, 353035058969001984, 2, '储物间', 2);
INSERT INTO `t_base_building_important_part` VALUES (353805917610524672, '5454/521654/56.jpg', NULL, 353035058969001984, 4, '电梯口', 2);
INSERT INTO `t_base_building_important_part` VALUES (353805917677633536, '558654/52544/57686.jpg', NULL, 353035058969001984, 2, '储物间', 2);
INSERT INTO `t_base_building_important_part` VALUES (353808166332088320, '5454/521654/56.jpg', NULL, 324041514078044456, 4, '电梯口', 2);
INSERT INTO `t_base_building_important_part` VALUES (353808166399197184, '558654/52544/57686.jpg', NULL, 324041514078044456, 2, '储物间', 2);

-- ----------------------------
-- Table structure for t_base_building_responsible_person
-- ----------------------------
DROP TABLE IF EXISTS `t_base_building_responsible_person`;
CREATE TABLE `t_base_building_responsible_person`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `type` int(2) NULL DEFAULT NULL COMMENT '类型:1,安全管理人,2,安全责任人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `idcard_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `safety_qualification_certificate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安全资格证图片路径',
  `building_id` bigint(20) NULL DEFAULT NULL COMMENT '建筑物id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_building_responsible_person
-- ----------------------------
INSERT INTO `t_base_building_responsible_person` VALUES (45, 'jksda ', 5, '45355658468', '54654646556731', 'jsdfhji/ksdjuvihu/jwahui.jpg', 5);

-- ----------------------------
-- Table structure for t_base_buildings
-- ----------------------------
DROP TABLE IF EXISTS `t_base_buildings`;
CREATE TABLE `t_base_buildings`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `building_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑编码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼栋名称',
  `type` int(2) NULL DEFAULT NULL COMMENT '类型:1商品房(小区)2商业综合体3工业厂房4办公写字楼5楼房6集贸市场7平房8别墅9特殊类建筑10其他',
  `safety_duty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安全责任人id',
  `safety_duty_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安全责任人姓名',
  `safety_duty_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安全责任人电话',
  `safety_manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安全管理人id(多个id使用逗号分隔)',
  `purpose` int(255) NULL DEFAULT NULL COMMENT '用途:',
  `belong_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属区',
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细位置',
  `territorial_jurisdiction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属地管辖部门',
  `rescue_jurisdiction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '救援管辖部门',
  `law_enforcement_jurisdiction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执法管理部门',
  `overground_num` int(10) NULL DEFAULT NULL COMMENT '地上层数',
  `underground_num` int(10) NULL DEFAULT NULL COMMENT '地下层数',
  `service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务名称',
  `project_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目Id',
  `dept_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属机构id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `fire_control_room` int(2) NULL DEFAULT NULL COMMENT '消防控制室(0表示无,1表示有)',
  `safe_exit` int(255) NULL DEFAULT NULL COMMENT '安全出口个数',
  `evacuation_staircase` int(255) NULL DEFAULT NULL COMMENT '疏散楼梯个数',
  `fire_lane` int(255) NULL DEFAULT NULL COMMENT '消防车道条数',
  `other_facilities` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他设施(多个设施名称以逗号分隔)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_buildings
-- ----------------------------
INSERT INTO `t_base_buildings` VALUES (324041514078044210, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441110', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044220, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441100', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044221, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441110', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044222, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441110', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044223, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441110', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044224, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441110', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044225, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441110', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044226, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441110', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044228, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441110', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044229, NULL, '金宝商务大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '113.8948000000', '23.5580900000', '广东省深圳市宝安区顺丰路15号金宝商务大厦', NULL, NULL, NULL, NULL, NULL, '安全云平台', '123', '3240415140780441110', '2019-09-23 18:05:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (324041514078044456, 'string', '京东方', 0, '353701922065825792', '返回广东人挺烦的', '个和法国法国', '353701922317484032,353701922468478976', 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 00:42:07', NULL, '2019-11-10 21:17:01', 3, NULL, 2, 2, '应急照明灯,抽风机');
INSERT INTO `t_base_buildings` VALUES (351625860565647360, '432', '1231', 2, '321', NULL, NULL, NULL, 2, '天津市,市辖区,和平区', '321', '34343', '', '321', '', '', 321, 444, NULL, '15165', NULL, '2019-11-05 03:22:28', NULL, '2019-11-08 01:36:20', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (352778843005337600, 'string', 'string', 0, '352770176507920384', 'string', 'string', NULL, 0, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 254, 454, 'string', 'string', 'string', '2019-11-08 07:44:01', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (352778955626594304, 'striwetrrng', '狗东西', 0, '45645', '申达股份', '544555', NULL, 0, 'yhftdrt ', '45.53', '12235.24', '电饭锅和故事的地方', '胜多负少广东人生巅峰', '真是的方式', 'string', 54, 450, '第三方', '123', 'uyudffhfgfg', '2019-11-08 07:44:28', NULL, '2019-11-09 07:02:04', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (352780037375344640, 'string', '黄金三计划', 0, '352779450999062528', 'wangwu', '1356465862', NULL, 0, 'string', '5455545.5456454', 'string', '526955.8598452132', 'string', 'string', 'string', 254, 454, 'string', '12345678', 'string', '2019-11-08 07:48:45', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353029972033224704, 'string', '京东方', 0, '353029775777546240', '东方红', '17455455656', NULL, 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 00:21:55', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353031731355009024, 'string', '京东方', 0, '353029775777546240', '东方红', '17455455656', NULL, 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 00:28:54', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353034463625297920, 'string', '京东方', 0, '353034150726025216', '东方红', '17555454466', NULL, 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 00:39:45', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353036665710395392, 'string', '京东方', 0, '353036476786360320', '东方红', '1782364466', '353036476786360320', 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 00:48:30', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353036964332257280, 'string', '京东方', 0, '353036476786360320', '东方红', '1782364466', NULL, 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 00:49:42', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353039385813008384, 'string', '京东方', 0, '353036476786360320', '东方红', '1782364466', NULL, 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 00:59:19', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353040036341170176, 'string', '京东方', 0, '353036476786360320', '东方红', '1782364466', NULL, 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 01:01:54', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353041438962565120, 'string', '京东方', 0, '353036476786360320', '东方红', '1782364466', NULL, 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 01:07:28', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353042741608529920, 'string', '京东方', 0, '353041845524840448', '东方红', '178564364466', NULL, 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 01:12:39', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_buildings` VALUES (353042782058397696, 'string', '京东方', 0, '353042781940957184', '东方红', '17884854466', '353041845524840448', 0, 'string', '5455456.455', 'string', '1541.455', 'string', 'string', 'string', 4544, 12345, 'string', 'string', 'string', '2019-11-09 01:12:49', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_base_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_base_dept`;
CREATE TABLE `t_base_dept`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名',
  `type` int(2) NULL DEFAULT NULL COMMENT '1 监管单位 2 管理单位',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父id',
  `project_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目Id',
  `server_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务名',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_dept
-- ----------------------------
INSERT INTO `t_base_dept` VALUES (3240415140780441100, '傲视彩科技有限公司', 2, NULL, NULL, NULL, '公司', '2019-09-23 18:06:41', NULL, NULL);
INSERT INTO `t_base_dept` VALUES (3240415140780441110, '金宝商务大厦物业', 1, NULL, NULL, NULL, '物业', '2019-09-23 18:06:41', NULL, NULL);

-- ----------------------------
-- Table structure for t_base_fire_fighting_water
-- ----------------------------
DROP TABLE IF EXISTS `t_base_fire_fighting_water`;
CREATE TABLE `t_base_fire_fighting_water`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `type` int(2) NULL DEFAULT NULL COMMENT '1河流 2湖泊 3人工湖 4消防水池',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `water_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水位',
  `water_capacity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '储水量',
  `water_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水源地址',
  `file_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '档案编号',
  `manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人电话',
  `belong_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属区域',
  `management_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理单位',
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地理位置',
  `service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务名称',
  `project_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目Id',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_fire_fighting_water
-- ----------------------------
INSERT INTO `t_base_fire_fighting_water` VALUES (2, 4, '2423324244', NULL, '999', '500', NULL, '', '', '', '广东省,深圳市,宝安区', '111222', '1', '1', '广东省深圳市宝安区金宝大厦', NULL, NULL, NULL, '2019-11-01 07:24:03', NULL, NULL);
INSERT INTO `t_base_fire_fighting_water` VALUES (3, 4, '2423324244', NULL, '999', '500', NULL, '', '', '', '广东省,深圳市,宝安区', '111222', '1', '1', '广东省深圳市宝安区金宝大厦', NULL, NULL, NULL, '2019-11-01 07:24:13', NULL, NULL);
INSERT INTO `t_base_fire_fighting_water` VALUES (4, 4, '2423324244', NULL, '999', '500', NULL, '', '', '', '广东省,深圳市,宝安区', '1111', '1', '1', '广东省深圳市宝安区金宝大厦', NULL, NULL, NULL, '2019-11-01 07:24:57', NULL, NULL);
INSERT INTO `t_base_fire_fighting_water` VALUES (7, 2, '1', NULL, '999', '1', NULL, '', '', '', '广东省,深圳市,宝安区', '321', '1', '1', '广东省深圳市宝安区金宝大厦', NULL, NULL, NULL, '2019-11-01 21:32:29', NULL, '2019-11-02 03:00:14');
INSERT INTO `t_base_fire_fighting_water` VALUES (10, 2, '1', NULL, '', '1', NULL, '', '', '', '广东省,深圳市,宝安区', '321', '1', '1', '广东省深圳市宝安区金宝大厦', NULL, NULL, NULL, '2019-11-01 22:14:52', NULL, '2019-11-02 03:00:06');
INSERT INTO `t_base_fire_fighting_water` VALUES (11, 2, '2423324244', NULL, '999', '500', NULL, '', '', '', '广东省,深圳市,宝安区', '321', '1', '1', '广东省深圳市宝安金宝大厦', NULL, NULL, NULL, '2019-11-01 22:15:25', NULL, '2019-11-02 03:00:11');
INSERT INTO `t_base_fire_fighting_water` VALUES (12, 3, '123456789', NULL, '4567', '1', NULL, NULL, NULL, NULL, '广东省,深圳市,宝安区', '321', '12321', '321321', '广东省深圳市宝安区金宝大厦', NULL, NULL, NULL, '2019-11-01 22:42:17', NULL, '2019-11-02 03:01:16');
INSERT INTO `t_base_fire_fighting_water` VALUES (350521231274622976, 3, '1', NULL, '40', '1', NULL, '', '孙润1', '15701549545', '广东省,深圳市,宝安区', '321', '1', '1', '广东省深圳市宝安区金宝大厦', NULL, NULL, NULL, '2019-11-02 03:13:04', NULL, '2019-11-02 06:22:56');
INSERT INTO `t_base_fire_fighting_water` VALUES (350535677975937024, 2, '1', NULL, '', '1', NULL, '', '', '', '广东省,深圳市,宝安区', '1', '1', '1', '广东省深圳市宝安区金宝大厦', NULL, NULL, NULL, '2019-11-02 04:10:28', NULL, NULL);
INSERT INTO `t_base_fire_fighting_water` VALUES (350540895279071232, 2, '1', NULL, '', '1', NULL, '', '', '', '广东省,深圳市,宝安区', '1', '1', '1', '广东省深圳市宝安区金宝大厦', NULL, NULL, NULL, '2019-11-02 04:31:12', NULL, NULL);
INSERT INTO `t_base_fire_fighting_water` VALUES (350570672518021120, 1, '321321432', NULL, '', '', NULL, '', '', '', '广东省,深圳市,宝安区', '1', '1', '1', '广东省深圳市宝安区金宝大厦', NULL, '1000', NULL, '2019-11-02 06:29:32', NULL, '2019-11-05 01:41:40');

-- ----------------------------
-- Table structure for t_base_fire_hydrant
-- ----------------------------
DROP TABLE IF EXISTS `t_base_fire_hydrant`;
CREATE TABLE `t_base_fire_hydrant`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '室外消防栓编号',
  `belong_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属区域',
  `belong_street` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属街道',
  `belong_community` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属社区',
  `unit_type` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '单位性质(1市政2工业3物业小区)',
  `start_date` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '启用日期',
  `water_gage` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供水水压',
  `runing_condition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运行情况',
  `manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人电话',
  `monitoring_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监管单位',
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地理位置',
  `service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务名称',
  `project_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目Id',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_fire_hydrant
-- ----------------------------
INSERT INTO `t_base_fire_hydrant` VALUES (350530313310126080, '6544698', 'undefined,undefined,undefined', NULL, NULL, 0, NULL, '1', '2', '发生多个地方感觉', '是个大黄蜂', NULL, NULL, NULL, '北京市东城区消火栓', NULL, NULL, NULL, '2019-11-02 03:49:09', NULL, '2019-11-02 07:58:40');
INSERT INTO `t_base_fire_hydrant` VALUES (350530384701374464, '6544698', '北京市,市辖区,东城区', NULL, NULL, 0, NULL, '1', '2', '发生多个地方感觉', '是个大黄蜂', NULL, NULL, NULL, '北京市东城区消火栓', NULL, NULL, NULL, '2019-11-02 03:49:26', NULL, '2019-11-02 07:59:12');
INSERT INTO `t_base_fire_hydrant` VALUES (351877879171858432, 'grfedsa', '', NULL, NULL, 0, '', '', '', '', '', '', NULL, NULL, '', NULL, '1000', NULL, '2019-11-05 20:03:54', NULL, NULL);

-- ----------------------------
-- Table structure for t_base_fire_ledger
-- ----------------------------
DROP TABLE IF EXISTS `t_base_fire_ledger`;
CREATE TABLE `t_base_fire_ledger`  (
  `id` bigint(11) NOT NULL COMMENT '主键id',
  `project_id` bigint(11) NULL DEFAULT NULL COMMENT '工程id',
  `system_type` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统类型',
  `ledger_type` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '台账类型(1消防设备2应急物资)',
  `brand` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `model` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号',
  `device_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备标签编号',
  `date_manufacture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产日期',
  `date_effective` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有效日期',
  `longitude` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `building_id` bigint(11) NULL DEFAULT NULL COMMENT '关联建筑物 id',
  `building_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑物名称',
  `install_location` varchar(160) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安装位置',
  `install_floor` int(2) NULL DEFAULT NULL COMMENT '安装楼层',
  `associated_unit_id` bigint(20) NULL DEFAULT NULL COMMENT '关联单位 id',
  `associated_unit_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联单位名称',
  `statue` int(2) NULL DEFAULT NULL COMMENT '设备状态：1:正常，2:误报，3:火警，4：未确认火警 ，5:故障,6:失联',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(25) NULL DEFAULT NULL COMMENT '创建人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `updater` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消防台账表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_fire_ledger
-- ----------------------------
INSERT INTO `t_base_fire_ledger` VALUES (768788787, 1000, '45', '14', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_fire_ledger` VALUES (354164164313956352, 1000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-11-12 03:28:47', NULL, NULL, NULL, NULL);
INSERT INTO `t_base_fire_ledger` VALUES (354164371923615744, 1000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-11-12 03:29:37', NULL, NULL, NULL, NULL);
INSERT INTO `t_base_fire_ledger` VALUES (354165120346832896, 44566, '45566554', '2', '和甲方同意', '2', '4554644', '456445645', '45456456', '44556564', '454564545', 15615616, '放的太害人的认同感', '456545', 454565, 42454, '东方', 454566, '2019-11-12 03:32:35', 1564654, '2019-11-12 03:45:51', NULL, '456345');
INSERT INTO `t_base_fire_ledger` VALUES (354165444763664384, 10000, '11111', NULL, 'string', '3', NULL, NULL, NULL, NULL, NULL, 15615616, 'string', NULL, NULL, 1515645, 'string', 1, '2019-11-12 03:33:52', 1564654, NULL, NULL, '1111');
INSERT INTO `t_base_fire_ledger` VALUES (354165967923396608, 44566, '45566554', '4', 'string', '4', '4554644', '456445645', '45456456', '44556564', '454564545', 15615616, '456645465', '456545', 454565, 42454, '546654564', 454566, '2019-11-12 03:35:57', 1564654, NULL, NULL, '456345');
INSERT INTO `t_base_fire_ledger` VALUES (354166168327241728, 44566, '45566554', '4', 'string', '4', '4554644', '456445645', '45456456', '44556564', '454564545', 15615616, '456645465', '456545', 454565, 42454, '东方', 454566, '2019-11-12 03:36:45', 1564654, NULL, NULL, '456345');
INSERT INTO `t_base_fire_ledger` VALUES (354166259536576512, 44566, '45566554', '4', 'string', '4', '4554644', '456445645', '45456456', '44556564', '454564545', 15615616, '456645465', '456545', 454565, 42454, '东方', 454566, '2019-11-12 03:37:07', 1564654, NULL, NULL, '456345');
INSERT INTO `t_base_fire_ledger` VALUES (354167677651730432, 44566, '45566554', '2', '和甲方同意', '2', '4554644', '456445645', '45456456', '44556564', '454564545', 15615616, '放的太害人的认同感', '456545', 454565, 42454, '东方', 454566, '2019-11-12 03:42:45', 1254, NULL, NULL, '456345');

-- ----------------------------
-- Table structure for t_base_inspection_task
-- ----------------------------
DROP TABLE IF EXISTS `t_base_inspection_task`;
CREATE TABLE `t_base_inspection_task`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `inspection_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查项',
  `inspection_item_type` int(2) NULL DEFAULT NULL COMMENT '巡检项类型:1 故障 2失联 3 重点巡检',
  `inpsection_type` int(2) NULL DEFAULT NULL COMMENT '巡检类型:1 基础巡检 2 功能巡检 3联网巡检 3报警测试 4 其他',
  `inspection_way` int(2) NULL DEFAULT NULL COMMENT '巡检方式: 1 人工巡检 2 自动巡检',
  `inspection_frequency` int(2) NULL DEFAULT NULL COMMENT '巡检频次: 1 不定时/单次 2 每周 3每月 4 每季度',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `inspection_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '巡检人员',
  `inspection_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '巡检时间',
  `status` int(2) NULL DEFAULT NULL COMMENT '任务状态: 1 未生效 2 已生效 3 已终止',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '巡查任务计划表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_base_items
-- ----------------------------
DROP TABLE IF EXISTS `t_base_items`;
CREATE TABLE `t_base_items`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置项',
  `child_count` int(2) NULL DEFAULT NULL COMMENT '子系统数量',
  `project_id` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目Id',
  `service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '巡查配置项' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_base_law_enforcement_team
-- ----------------------------
DROP TABLE IF EXISTS `t_base_law_enforcement_team`;
CREATE TABLE `t_base_law_enforcement_team`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '救援队伍名称',
  `belong_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属区域',
  `belong_street` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属街道',
  `belong_community` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属社区',
  `unit_type` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '单位性质(1安监局2安监办3消防监督管理大队)',
  `norm_num` int(10) NULL DEFAULT NULL COMMENT '标准人数',
  `reality_num` int(10) NULL DEFAULT NULL COMMENT '实际人数',
  `fire_truck_norm_num` int(11) NULL DEFAULT NULL COMMENT '消防车标准数量',
  `fire_truck_reality_num` int(11) NULL DEFAULT NULL COMMENT '消防车实际数量',
  `manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人电话',
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地理位置',
  `service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务名称',
  `project_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目Id',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_law_enforcement_team
-- ----------------------------
INSERT INTO `t_base_law_enforcement_team` VALUES (350545061309267968, '执法', '北京市,市辖区,东城区', NULL, NULL, 1, 45, 564154, NULL, NULL, '李四', '13245785255', '都是给大哥大哥', '第三方', '十多个', NULL, NULL, NULL, '2019-11-02 04:47:46', NULL, '2019-11-02 07:15:57');
INSERT INTO `t_base_law_enforcement_team` VALUES (350582582466527232, '执法队伍二队', '北京市,市辖区,东城区', NULL, NULL, 2, 40, 40, NULL, NULL, '李四', '13545678989', NULL, NULL, '北京市东城区执法队伍二队', NULL, NULL, NULL, '2019-11-02 07:16:51', NULL, NULL);

-- ----------------------------
-- Table structure for t_base_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_base_menu`;
CREATE TABLE `t_base_menu`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键权限id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父Id',
  `type` int(2) NULL DEFAULT NULL COMMENT '1 web端 2App端',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `sort_num` int(10) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_base_message
-- ----------------------------
DROP TABLE IF EXISTS `t_base_message`;
CREATE TABLE `t_base_message`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `type` int(2) NULL DEFAULT NULL COMMENT '消息类型(1 短信 2 微信)',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_base_project
-- ----------------------------
DROP TABLE IF EXISTS `t_base_project`;
CREATE TABLE `t_base_project`  (
  `id` bigint(21) NOT NULL COMMENT '主键',
  `projactName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工程名字',
  `projactCode` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工程code',
  `desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工程介绍',
  `address` varchar(130) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工程地址',
  `createDate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` bigint(21) NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_base_rescue_team
-- ----------------------------
DROP TABLE IF EXISTS `t_base_rescue_team`;
CREATE TABLE `t_base_rescue_team`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '救援队伍名称',
  `belong_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属区域',
  `belong_street` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属街道',
  `belong_community` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属社区',
  `unit_type` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '单位性质(1微型消防站2社区小型消防站3街道专\r\n职消防队4武警消防中队5武警消防大队6武警消防支队)',
  `norm_num` int(10) NULL DEFAULT NULL COMMENT '标准人数',
  `reality_num` int(10) NULL DEFAULT NULL COMMENT '实际人数',
  `fire_truck_norm_num` int(11) NULL DEFAULT NULL COMMENT '消防车标准数量',
  `fire_truck_reality_num` int(11) NULL DEFAULT NULL COMMENT '消防车实际数量',
  `manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人电话',
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地理位置',
  `service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务名称',
  `project_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目Id',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_rescue_team
-- ----------------------------
INSERT INTO `t_base_rescue_team` VALUES (350579164192653312, '32132', '北京市,市辖区,西城区', NULL, NULL, 2, 321, 321, 321, 0, '111', '11', NULL, NULL, '321', NULL, NULL, NULL, '2019-11-02 07:03:16', NULL, '2019-11-02 07:17:32');

-- ----------------------------
-- Table structure for t_base_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_base_resource`;
CREATE TABLE `t_base_resource`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源code',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_base_role
-- ----------------------------
DROP TABLE IF EXISTS `t_base_role`;
CREATE TABLE `t_base_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键角色id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型1系统管理员2.厂家人员3.运维人员4.普通用户',
  `project_id` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目Id',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_role
-- ----------------------------
INSERT INTO `t_base_role` VALUES (1, '运营人员', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_role` VALUES (2, '企业领导', '3', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_role` VALUES (3, '企业办事员', '4', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_role` VALUES (4, '企业', '5', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_role` VALUES (5, NULL, '6', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_role` VALUES (324479751306874880, '系统管理员', '1', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_base_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_base_role_menu`;
CREATE TABLE `t_base_role_menu`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单id',
  `operation_authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作权限(字符串拼接)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_role_menu
-- ----------------------------
INSERT INTO `t_base_role_menu` VALUES (324479751306874880, 324479751306874880, 324479751306874880, NULL);

-- ----------------------------
-- Table structure for t_base_user
-- ----------------------------
DROP TABLE IF EXISTS `t_base_user`;
CREATE TABLE `t_base_user`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密钥',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最近登录时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `delete` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除',
  `project_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目Id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_user
-- ----------------------------
INSERT INTO `t_base_user` VALUES (1, NULL, '', '', '', '', NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_base_user` VALUES (324479751306874880, 'as', 'a', 'enbTnQJFtmj4lPWulSk1FQUlBzFFMnn7qRMag7zdSsY=', '18574803964', '7fbf48ad-1fe5-439f-8f64-86f24c429af2', NULL, '18574803964@163.com', NULL, 'a', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_base_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_base_user_role`;
CREATE TABLE `t_base_user_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_user_role
-- ----------------------------
INSERT INTO `t_base_user_role` VALUES (324479751306874880, 324479751306874880, 324479751306874880);

SET FOREIGN_KEY_CHECKS = 1;
