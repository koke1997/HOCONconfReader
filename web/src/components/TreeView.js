import React, { useState, useEffect } from 'react';

const TreeNode = ({ node, level }) => {
  const [expanded, setExpanded] = useState(false);

  const handleToggle = () => {
    setExpanded(!expanded);
  };

  return (
    <div style={{ marginLeft: level * 20 }}>
      <div onClick={handleToggle} style={{ cursor: 'pointer' }}>
        {node.children && (expanded ? '-' : '+')} {node.key}: {node.value}
      </div>
      {expanded && node.children && (
        <div>
          {node.children.map((childNode) => (
            <TreeNode key={childNode.key} node={childNode} level={level + 1} />
          ))}
        </div>
      )}
    </div>
  );
};

const TreeView = ({ results }) => {
  const [treeData, setTreeData] = useState([]);

  useEffect(() => {
    const buildTree = (data) => {
      const tree = [];
      const map = {};

      Object.entries(data).forEach(([key, value]) => {
        const parts = key.split('.');
        let currentLevel = tree;

        parts.forEach((part, index) => {
          if (!map[part]) {
            const newNode = {
              key: part,
              value: index === parts.length - 1 ? value : '',
              children: [],
            };
            currentLevel.push(newNode);
            map[part] = newNode;
          }

          currentLevel = map[part].children;
        });
      });

      return tree;
    };

    setTreeData(buildTree(results));
  }, [results]);

  return (
    <div>
      <h2>Parsed Results (Tree View)</h2>
      {treeData.map((node) => (
        <TreeNode key={node.key} node={node} level={0} />
      ))}
    </div>
  );
};

export default TreeView;
