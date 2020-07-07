SELECT 
  t.`turbine_id`,
  t.`availbility_status`,
  t.`active_code`,
  MIN(t.create_time) AS stop_time,
  (
        MAX( t.total_mannul_stop_time_length ) - MIN( t.total_mannul_stop_time_length ) +
        MAX( t.total_wether_stop_time_length ) - MIN( t.total_wether_stop_time_length )+
        MAX( t.total_grid_fault_stop_time_length ) - MIN( t.total_grid_fault_stop_time_length )*
        MAX( t.total_turbine_fault_stop_time_length ) - MIN( t.total_turbine_fault_stop_time_length )
  ) stop_time_length
        
FROM
  t_main_state_log t 
WHERE t.`availbility_status` != '运行' 
  AND t.`create_time` BETWEEN DATE_SUB(NOW(), INTERVAL 1 HOUR) 
  AND DATE_ADD(NOW(), INTERVAL 2 SECOND) 
GROUP BY t.`turbine_id`,
  t.`availbility_status`,
  t.`active_code` 
